package com.didactapp.server.services;

import com.didactapp.server.api.v1.model.BookDTO;

import java.util.List;

/**
 * The interface service in the book api.
 */
public interface BookService {

    List<BookDTO> getAllBooks();

    BookDTO getBookByBookId(long book_id);
}
