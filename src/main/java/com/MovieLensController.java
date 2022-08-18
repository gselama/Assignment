package com;

import com.Bean.StatusBean;
import com.Repository.*;
import com.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @RequestMapping(value = "/getMoviesByGenre", method = RequestMethod.GET)
    public List<Movie> fetchMoviesByGenre() {
        return movieRepository.findAll();
    }

    @RequestMapping(value = "/getMoviesByDateRange", method = RequestMethod.GET)
    public List<Movie> fetchMoviesByDateRange() {
        return movieRepository.findAll();
    }

    @RequestMapping(value = "/getMoviesByRating", method = RequestMethod.GET)
    public List<Movie> fetchMoviesByRating() {
        return movieRepository.findAll();
    }
}
