package com.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "LINK")
public class Link {

    @Column(name = "MOVIEID")
    @EmbeddedId
    private final Integer movieId;

    @Column(name = "IMDB_ID")
    private final String imdbId;

    @Column(name = "TMDB_ID")
    private final String tmdbId;


    public Link(Integer movieId, String imdbId, String tmdbId) {
        this.movieId = movieId;
        this.imdbId = imdbId;
        this.tmdbId = tmdbId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public String getImdbId() {
        return imdbId;
    }

    public String getTmdbId() {
        return tmdbId;
    }
}
