package com.didactapp.server.services;

import com.didactapp.server.api.v1.model.AuthorDTO;

import java.util.List;

/**
 * Created by jt on 9/26/17.
 */
public interface AuthorService {
    List<AuthorDTO> getAuthorsByBookId(long book_id);
}
