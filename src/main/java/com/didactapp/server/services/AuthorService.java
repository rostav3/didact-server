package com.didactapp.server.services;

import com.didactapp.server.api.v1.model.AuthorDTO;

import java.util.List;

/**
 * The interface service in the author api.
 */
public interface AuthorService {
    List<AuthorDTO> getAuthorsByBookId(long book_id);
}
