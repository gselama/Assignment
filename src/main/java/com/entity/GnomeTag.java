package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GENOME_TAGS")
public class GnomeTag {

    @Id
    @Column(name = "TAG_ID")
    private final long tagId;


    @Column(name = "TAG_NAME")
    private final String tagName;

    public GnomeTag(Integer tagId, String tagName) {
        this.tagId = tagId;
        this.tagName = tagName;

    }

    public long getTagId() {
        return tagId;
    }

    public String getTagName() {
        return tagName;
    }
}
