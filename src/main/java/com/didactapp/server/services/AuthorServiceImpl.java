package com.didactapp.server.services;

import com.didactapp.server.api.v1.mapper.AuthorMapper;
import com.didactapp.server.api.v1.model.AuthorDTO;
import com.didactapp.server.api.v1.model.BookDTO;
import com.didactapp.server.domain.Author;
import com.didactapp.server.domain.Book;
import com.didactapp.server.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jt on 9/26/17.
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorMapper authorMapper;
    private AuthorRepository authorRepository;

    @Autowired
    public void setAuthorMapper(AuthorMapper authorMapper) {
        this.authorMapper = authorMapper;
    }

    @Autowired
    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<AuthorDTO> getAuthorsByBookId(long book_id) {
        List<Author> b = authorRepository.findAuthorsByBookId(book_id);
        Stream<Author> b2 = b.stream();
        Stream<AuthorDTO> b3 = b2.map(authorMapper::authorToAuthorDTO);

        return b3.collect(Collectors.toList());
    }
}