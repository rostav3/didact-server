package com.didactapp.server.repositories;

import com.didactapp.server.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jt on 9/24/17.
 */
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByBookId(long book_id);

}
