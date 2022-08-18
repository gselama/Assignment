package com;

import com.Repository.*;
import com.entity.*;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class MoviePipeline {

    private static final String pathToCsv = "/home/arun/Documents/Gopi/";
    private static final String movieFileName = "movies.csv";
    private static final String tagFileName = "tags.csv";
    private static final String linkFileName = "links.csv";
    private static final String ratingFileName = "ratings.csv";
    private static final String gnomeTagFileName = "genome-tags.csv";
    private static final String gnomeScoreFileName = "genome-scores.csv";
    private static final long n = 1;

    private static String SUCCESS = "success";
    private static String FAIl = "failure";

    BufferedReader csvReader;

    public String loadMovies(MovieRepository repository) {

        try {
            csvReader = new BufferedReader(new FileReader(pathToCsv + movieFileName));
            String row = "";
            List<Movie> movies = new ArrayList<>();
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                String tmp = data[1].substring(data[1].lastIndexOf(' ') + 1);
                String mov = data[1].replaceAll(tmp, "").replaceAll("[()]", "");
                String yearStr = tmp.replaceAll("[()]", "");
                try {
                    if (yearStr.equalsIgnoreCase("movieId") || yearStr.equalsIgnoreCase("title") || yearStr.equalsIgnoreCase("genres")) {
                        continue;
                    }
                    Integer year = Integer.parseInt(yearStr);
                    Movie movie = new Movie(Long.parseLong(data[0]), mov, year, data[2]);
                    movies.add(movie);
                } catch (Exception e) {
                    e.printStackTrace();
                    return FAIl;
                }
            }
            repository.save(movies);
            repository.flush();
            csvReader.close();
            return SUCCESS;

        } catch (Exception e) {
            e.printStackTrace();
            if (repository != null) {
                repository.flush();
            }
            return FAIl;

        }
    }

    public String loadRatings(RatingRepository repository) {

        try {
            csvReader = new BufferedReader(new FileReader(pathToCsv + ratingFileName));
            String row = "";
            List<Rating> ratings = new ArrayList<>();
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                try {
                    if (data[0].equalsIgnoreCase("userId")) {
                        continue;
                    }
                    Rating rating = new Rating(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Double.parseDouble(data[2]), Long.parseLong(data[3]));
                    ratings.add(rating);
                } catch (Exception e) {
                    e.printStackTrace();
                    return FAIl;
                }
            }
            repository.save(ratings);
            repository.flush();
            csvReader.close();
            return SUCCESS;

        } catch (Exception e) {
            e.printStackTrace();
            if (repository != null) {
                repository.flush();
            }
            return FAIl;
        }

    }

    public String loadTags(TagRepository repository) {

        try {
            csvReader = new BufferedReader(new FileReader(pathToCsv + tagFileName));
            String row = "";
            List<Tag> tags = new ArrayList<>();
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                try {
                    if (data[0].equalsIgnoreCase("userId")) {
                        continue;
                    }
                    Tag tag = new Tag(Integer.parseInt(data[0]), Integer.parseInt(data[1]), data[2], Long.parseLong(data[3]));
                    tags.add(tag);
                } catch (Exception e) {
                    e.printStackTrace();
                    return FAIl;
                }
            }
            repository.save(tags);
            repository.flush();
            csvReader.close();
            return SUCCESS;

        } catch (Exception e) {
            e.printStackTrace();
            if (repository != null) {
                repository.flush();
            }
            return FAIl;
        }

    }

    public String loadLinks(LinkRepository repository) {

        try {
            csvReader = new BufferedReader(new FileReader(pathToCsv + linkFileName));
            String row = "";
            List<Link> links = new ArrayList<>();
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                try {
                    if (data[0].equalsIgnoreCase("userId")) {
                        continue;
                    }
                    Link link = new Link(Integer.parseInt(data[0]), data[1], data[2]);
                    links.add(link);
                } catch (Exception e) {
                    e.printStackTrace();
                    return FAIl;
                }
            }
            repository.save(links);
            repository.flush();
            csvReader.close();
            return SUCCESS;

        } catch (Exception e) {
            e.printStackTrace();
            if (repository != null) {
                repository.flush();
            }
            return FAIl;
        }

    }

    public String loadGenomeTags(GenomeTagRepository repository) {

        try {
            csvReader = new BufferedReader(new FileReader(pathToCsv + gnomeTagFileName));
            String row = "";
            List<GnomeTag> gnomeTags = new ArrayList<>();
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                try {
                    if (data[0].equalsIgnoreCase("tagId")) {
                        continue;
                    }
                    GnomeTag gnomeTag = new GnomeTag(Integer.parseInt(data[0]), data[1]);
                    gnomeTags.add(gnomeTag);
                } catch (Exception e) {
                    e.printStackTrace();
                    return FAIl;
                }
            }
            repository.save(gnomeTags);
            repository.flush();
            csvReader.close();
            return SUCCESS;

        } catch (Exception e) {
            e.printStackTrace();
            if (repository != null) {
                repository.flush();
            }
            return FAIl;
        }

    }

    public String loadGnomeScores(GenomeScoreRepository repository) {

        try {
            csvReader = new BufferedReader(new FileReader(pathToCsv + gnomeScoreFileName));
            String row = "";
            List<GnomeScore> genomeScores = new ArrayList<>();
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                try {
                    if (data[0].equalsIgnoreCase("movieId")) {
                        continue;
                    }
                    GnomeScore gnomeScore = new GnomeScore(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Double.parseDouble(data[2]));
                    genomeScores.add(gnomeScore);
                } catch (Exception e) {
                    e.printStackTrace();
                    return FAIl;
                }
            }
            repository.save(genomeScores);
            repository.flush();
            csvReader.close();
            return SUCCESS;

        } catch (Exception e) {
            e.printStackTrace();
            if (repository != null) {
                repository.flush();
            }
            return FAIl;
        }

    }
}
