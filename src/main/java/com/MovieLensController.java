package com;

import com.Bean.StatusBean;
import com.Repository.*;
import com.entity.Movie;
import com.entity.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

/*
* MovieLensController class is the maser controller
* APIS for simple fetch and for pipeline
*/
@RestController
@RequestMapping("/api")
public class MovieLensController {

    @Autowired
    MoviePipeline moviePipeline;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TagRepository tagRepository;

    @Autowired
    LinkRepository linkRepository;

    @Autowired
    RatingRepository ratingRepository;

    @Autowired
    GenomeScoreRepository genomeScoreRepository;

    @Autowired
    GenomeTagRepository genomeTagRepository;

    /*
     * Method to trigger the data pipeline
     */
    @RequestMapping(value = "/load", method = RequestMethod.GET)
    public StatusBean loadAll() {
        StatusBean status = new StatusBean();
        status.setMovieLoadStatus(moviePipeline.loadMovies(movieRepository));
        status.setTagLoadStatus(moviePipeline.loadTags(tagRepository));
        status.setLinkLoadStatus(moviePipeline.loadLinks(linkRepository));
        status.setRatingLoadStatus(moviePipeline.loadRatings(ratingRepository));
        status.setGenomeScoreLoadStatus(moviePipeline.loadGnomeScores(genomeScoreRepository));
        status.setGenomeTagLoadStatus(moviePipeline.loadGenomeTags(genomeTagRepository));
        return status;
    }

    /*
     * Method to fetch the movies based on genre
     */
    @RequestMapping(value = "/getMoviesByGenre", method = RequestMethod.GET)
    public List<Movie> fetchMoviesByGenre(@RequestParam("genre") String genre) {
        return movieRepository.findByGenreLike(genre);
    }

    /*
     * Method to fetch the movies based on release year
     */
    @RequestMapping(value = "/getMoviesByDateRange", method = RequestMethod.GET)
    public List<Movie> fetchMoviesByDateRange(@RequestParam("from") Integer from, @RequestParam("to") Integer to) {
        return movieRepository.fineAllByYearGreaterThanEqualAndLessThanEqual(from, to);
    }

    /*
     * Method to fetch the movies based on rating
     */
    @RequestMapping(value = "/getMoviesByRating", method = RequestMethod.GET)
    public List<Movie> fetchMoviesByRating(@RequestParam("rating") Double rating) {
        List<Movie> movies = null;
        Rating rt = ratingRepository.findAllByRaingIn(rating);
        if (rt != null && rt.getMovies() != null && rt.getMovies().size() > 0) {
            movies = new ArrayList<>();
            for (Movie movie : rt.getMovies()) {
                movies.add(movie);
            }
        }
        return movies;
    }
}
