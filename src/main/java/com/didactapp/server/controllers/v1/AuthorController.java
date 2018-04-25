package com.didactapp.server.controllers.v1;

import com.didactapp.server.api.v1.model.AuthorDTO;
import com.didactapp.server.error.CustomException;
import com.didactapp.server.services.AuthorService;
import com.didactapp.server.services.JWTUserAuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * The class represent the api of the authors
 */

@Controller
@RequestMapping("/api/v1/authors/")
public class AuthorController {

    private final AuthorService authorService;
    private final JWTUserAuthenticationService jwtUserAuthenticationService;

    public AuthorController(AuthorService authorService, JWTUserAuthenticationService jwtUserAuthenticationService) {
        this.authorService = authorService;
        this.jwtUserAuthenticationService = jwtUserAuthenticationService;
    }

    /**
     * The get call of all authors of a book.
     * @param book_id - The book we want to get is authors
     * @param authentication_key - code for authenticate the user
     * @return all the authors of the book
     */
    @GetMapping("books/{book_id}/{authentication_key}")
    public ResponseEntity<List<AuthorDTO>> getAuthorsByBookId(@PathVariable long book_id,
                                                              @PathVariable String authentication_key){
        if (!jwtUserAuthenticationService.isUserAutheticated(authentication_key)){
            throw new CustomException("USER_NOT_AUTHENTICATION");
        }
        return new ResponseEntity<>(authorService.getAuthorsByBookId(book_id), HttpStatus.OK);
    }
}
