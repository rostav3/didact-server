package com.didactapp.server.api.v1.model;

import lombok.Data;

/**
 * Created by jt on 9/24/17.
 */
@Data
public class AuthorDTO {
    private long authorId;
    private String firstName;
    private String lastName;
    private String about;

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
