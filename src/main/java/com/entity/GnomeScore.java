package com.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "GENOME_SCORES")
public class GnomeScore {

    @Column(name = "MOVIEID")
    @EmbeddedId
    private final Integer movieId;

    @Column(name = "TAG_ID")
    private final Integer tagId;

    @Column(name = "RELEVANCE")
    private final Double relevance;


    public GnomeScore(Integer movieId, Integer tagId, Double relevance) {
        this.movieId = movieId;
        this.tagId = tagId;
        this.relevance = relevance;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public Double getRelevance() {
        return relevance;
    }
}
