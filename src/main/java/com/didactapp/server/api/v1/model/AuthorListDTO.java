package com.didactapp.server.api.v1.model;
import java.util.List;

/**
 * Created by jt on 9/26/17.
 */
public class AuthorListDTO {
    private List<AuthorDTO> authors;

    public AuthorListDTO(List<AuthorDTO> authors) {
        this.authors = authors;
    }

    public List<AuthorDTO> getAuthors() {
        return authors;
    }
}
