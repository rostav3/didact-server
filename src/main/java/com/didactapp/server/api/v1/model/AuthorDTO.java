package com.didactapp.server.api.v1.model;


/**
 * The class represent the AuthorDTO (Data transfer object) - the Author object for communicate with the client
 */

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
