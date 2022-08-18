package com.Bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


/*
 * StatusBean shares the status of data pipeline
 */
@Component
public class StatusBean {

    private String movieLoadStatus;

    private String tagLoadStatus;

    private String linkLoadStatus;

    private String ratingLoadStatus;

    private String genomeTagLoadStatus;

    private String genomeScoreLoadStatus;

    public String getMovieLoadStatus() {
        return movieLoadStatus;
    }

    public void setMovieLoadStatus(String movieLoadStatus) {
        this.movieLoadStatus = movieLoadStatus;
    }

    public String getTagLoadStatus() {
        return tagLoadStatus;
    }

    public void setTagLoadStatus(String tagLoadStatus) {
        this.tagLoadStatus = tagLoadStatus;
    }

    public String getLinkLoadStatus() {
        return linkLoadStatus;
    }

    public void setLinkLoadStatus(String linkLoadStatus) {
        this.linkLoadStatus = linkLoadStatus;
    }

    public String getRatingLoadStatus() {
        return ratingLoadStatus;
    }

    public void setRatingLoadStatus(String ratingLoadStatus) {
        this.ratingLoadStatus = ratingLoadStatus;
    }

    public String getGenomeTagLoadStatus() {
        return genomeTagLoadStatus;
    }

    public void setGenomeTagLoadStatus(String genomeTagLoadStatus) {
        this.genomeTagLoadStatus = genomeTagLoadStatus;
    }

    public String getGenomeScoreLoadStatus() {
        return genomeScoreLoadStatus;
    }

    public void setGenomeScoreLoadStatus(String genomeScoreLoadStatus) {
        this.genomeScoreLoadStatus = genomeScoreLoadStatus;
    }
}
