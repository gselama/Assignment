package com.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "RATING")
public class Rating {


    @Column(name = "USERID")
    private final Integer userId;

    @Column(name = "MOVIEID")
    @EmbeddedId
    private final Integer movieId;

    @Column(name = "RATING")
    private final Double rating;

    @Column(name = "UPDATED_ON")
    private final Long updated_on;

    @OneToMany(mappedBy = "rating")
    private Set<Movie> movies;

    public Rating(Integer userId, Integer movieId, Double rating, Long updated_on) {
        this.userId = userId;
        this.movieId = movieId;
        this.rating = rating;
        this.updated_on = updated_on;
    }


    public Integer getUserId() {
        return userId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public Double getRating() {
        return rating;
    }

    public Long getUpdated_on() {
        return updated_on;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
