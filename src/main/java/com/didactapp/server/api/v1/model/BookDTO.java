package com.didactapp.server.api.v1.model;

import lombok.Data;

/**
 * Created by jt on 9/24/17.
 */
@Data
public class BookDTO {
    private long bookId;
    private String coverUrl;
    private String thumbnailUrl;
    private String title;
    private String tagLine;
    private String description;
    private int publishedDate;
    private int revisionDate;
    private int version;

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTagLine(String tagLine) {
        this.tagLine = tagLine;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPublishedDate(int publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void setRevisionDate(int revisionDate) {
        this.revisionDate = revisionDate;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
