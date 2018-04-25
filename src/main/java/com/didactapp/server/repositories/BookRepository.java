package com.didactapp.server.repositories;

import com.didactapp.server.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface connection with the book table in db
 */
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByBookId(long book_id);

}
