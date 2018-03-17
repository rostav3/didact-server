package com.didactapp.server.repositories;

import com.didactapp.server.domain.Author;

import java.util.List;

/**
 * Created by jt on 9/24/17.
 */
public interface AuthorRepositoryCustom {

    List<Author> findAuthorsByBookId(long book_id);
}
