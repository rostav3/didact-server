package com.didactapp.server.services;

import com.didactapp.server.api.v1.mapper.AuthorMapper;
import com.didactapp.server.api.v1.model.AuthorDTO;
import com.didactapp.server.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The service class in the author api.
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


    /**
     * return the authors of the book
     * @param book_id - the book
     * @return list authors of the book
     */
    @Override
    public List<AuthorDTO> getAuthorsByBookId(long book_id) {
        return  authorRepository.findAuthorsByBookId(book_id).stream().map(authorMapper::authorToAuthorDTO).collect(Collectors.toList());
    }
}
