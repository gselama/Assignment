package com.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TAG")
public class Tag {


    @Column(name = "USERID")
    private final Integer userId;

    @Column(name = "MOVIEID")
    @EmbeddedId
    private final Integer movieId;

    @Column(name = "TAG")
    private final String tag;

    @Column(name = "UPDATED_ON")
    private final Long updated_on;


    public Tag(Integer userId, Integer movieId, String tag, Long updated_on) {
        this.userId = userId;
        this.movieId = movieId;
        this.tag = tag;
        this.updated_on = updated_on;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public String getTag() {
        return tag;
    }

    public Long getUpdated_on() {
        return updated_on;
    }
}
