package com.didactapp.server.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The class represent the Section entity
 */

@Entity
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sectionId;
    private int chapterId;
    private int sectionNum;
    private String name;
    private String explanation;
    private String imageUrl;
    private String question;
    private String wrongAnswer1;
    private String wrongAnswer2;
    private String wrongAnswer3;
    private String correctAnswer;

    public Section() {
    }

    public int getSectionId() {
        return sectionId;
    }

    public int getChapterId() {
        return chapterId;
    }

    public int getSectionNum() {
        return sectionNum;
    }

    public String getName() {
        return name;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getQuestion() {
        return question;
    }

    public String getWrongAnswer1() {
        return wrongAnswer1;
    }

    public String getWrongAnswer2() {
        return wrongAnswer2;
    }

    public String getWrongAnswer3() {
        return wrongAnswer3;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
