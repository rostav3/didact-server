package com.didactapp.server.services;

import com.didactapp.server.api.v1.model.BookDTO;

import java.util.List;

/**
 * Created by jt on 9/26/17.
 */
public interface BookService {

    List<BookDTO> getAllBooks();

    BookDTO getBookByBookId(long book_id);
}
