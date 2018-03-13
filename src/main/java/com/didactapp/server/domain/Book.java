package com.didactapp.server.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by jt on 9/24/17.
 */
@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookId;
    private String coverUrl;
    private String thumbnailUrl;
    private String title;
    private String tagLine;
    private String description;
    private int publishedDate;
    private int revisionDate;
    private int version;

    public Book() {
    }

    public long getBookId() {
        return bookId;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getTagLine() {
        return tagLine;
    }

    public String getDescription() {
        return description;
    }

    public int getPublishedDate() {
        return publishedDate;
    }

    public int getRevisionDate() {
        return revisionDate;
    }

    public int getVersion() {
        return version;
    }

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

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", coverUrl='" + coverUrl + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", title='" + title + '\'' +
                ", tagLine='" + tagLine + '\'' +
                ", description='" + description + '\'' +
                ", publishedDate='" + publishedDate + '\'' +
                ", revisionDate='" + revisionDate + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
