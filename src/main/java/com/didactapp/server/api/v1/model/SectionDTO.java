package com.didactapp.server.api.v1.model;

/**
 * Created by jt on 9/24/17.
 */
public class SectionDTO {
    private int sectionId;
    private int chapterId;
    private int sectionNum;

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public int getSectionNum() {
        return sectionNum;
    }

    public void setSectionNum(int sectionNum) {
        this.sectionNum = sectionNum;
    }
}
