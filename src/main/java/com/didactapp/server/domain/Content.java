package com.didactapp.server.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contentId;
    private int sectionId;
    private int contentNum;
    private String type;
    private String contentUrl;

    public Content() {
    }

    public int getContnetId() {
        return contentId;
    }

    public void setContnetId(int contnetId) {
        this.contentId = contnetId;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public int getContentNum() {
        return contentNum;
    }

    public void setContentNum(int contentNum) {
        this.contentNum = contentNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent_url() {
        return contentUrl;
    }

    public void setContent_url(String content_url) {
        this.contentUrl = content_url;
    }

    @Override
    public String toString() {
        return "Content{" +
                "contnetId=" + contentId +
                ", sectionId=" + sectionId +
                ", contentNum=" + contentNum +
                ", type='" + type + '\'' +
                ", content_url='" + contentUrl + '\'' +
                '}';
    }
}
