package com.didactapp.server.services;

import com.didactapp.server.api.v1.mapper.BookMapper;
import com.didactapp.server.api.v1.model.BookDTO;
import com.didactapp.server.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The service class in the book api.
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

    /**
     * return all the books
     * @return list of all the books
     */
    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream().map(bookMapper::bookToBookDTO).collect(Collectors.toList());
    }

    /**
     * return the book by is id
     * @param book_id - the book id
     * @return the book
     */
    @Override
    public BookDTO getBookByBookId(long book_id) {
        return bookMapper.bookToBookDTO(bookRepository.findByBookId(book_id));
    }
}