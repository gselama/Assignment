package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIE")
public class Movie {

    @Id
    @Column(name = "MOVIE_ID")
    private final long movieId;
    @Column(name = "TITLE")
    private final String title;

    @Column(name = "RELEASE_YEAR")
    private final Integer year;
    @Column(name = "GENRES")
    private final String genre;

    public Movie(long movieId, String title, Integer year, String genre) {
        this.movieId = movieId;
        this.title = title;
        this.year = year;
        this.genre = genre;
    }

    public long getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getYear() {
        return year;
    }


}