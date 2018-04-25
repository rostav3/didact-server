package com.didactapp.server.repositories;

import com.didactapp.server.domain.Author;

import java.util.List;

/**
 * The interface connection with the author table in db, for not usual queries.
 */
public interface AuthorRepositoryCustom {

    List<Author> findAuthorsByBookId(long book_id);
}
