package com.didactapp.server.services;

import com.didactapp.server.api.v1.mapper.BookMapper;
import com.didactapp.server.api.v1.model.BookDTO;
import com.didactapp.server.domain.Book;
import com.didactapp.server.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jt on 9/26/17.
 */
@Service
public class BookServiceImpl implements BookService {

    private BookMapper bookMapper;
    private BookRepository bookRepository;

    @Autowired
    public void setBookMapper(BookMapper bookMapper2) {
        this.bookMapper = bookMapper2;
    }

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> b = bookRepository.findAll();
        Stream<Book> b2 = b.stream();
        Stream<BookDTO> b3 = b2.map(bookMapper::bookToBookDTO);

        return b3.collect(Collectors.toList());
    }

    @Override
    public BookDTO getBookByBookId(long book_id) {
        return bookMapper.bookToBookDTO(bookRepository.findByBookId(book_id));
    }
}