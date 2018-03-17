package com.didactapp.server.controllers.v1;

import com.didactapp.server.api.v1.model.AuthorListDTO;
import com.didactapp.server.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jt on 9/26/17.
 */
@Controller
@RequestMapping("/api/v1/authors_book/")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("{book_id}")
    public ResponseEntity<AuthorListDTO> getAuthorsByBookId(@PathVariable long book_id){

        return new ResponseEntity<>(
                new AuthorListDTO(authorService.getAuthorsByBookId(book_id)), HttpStatus.OK);
    }
}
