package com.didactapp.server.controllers.v1;

import com.didactapp.server.api.v1.model.BookDTO;
import com.didactapp.server.error.CustomException;
import com.didactapp.server.services.AuthenticationService;
import com.didactapp.server.services.BookService;
import com.didactapp.server.services.JWTUserAuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by jt on 9/26/17.
 */
@Controller
@RequestMapping("/api/v1/books/")
public class BookController {

    private final BookService bookService;
    private final AuthenticationService authenticationService;
    private final JWTUserAuthenticationService jwtUserAuthenticationService;

    public BookController(BookService bookService, AuthenticationService authenticationService, JWTUserAuthenticationService jwtUserAuthenticationService) {
        this.bookService = bookService;
        this.authenticationService = authenticationService;
        this.jwtUserAuthenticationService = jwtUserAuthenticationService;
    }

    @GetMapping("all/{authentication_key}")
    public ResponseEntity<List<BookDTO>> getallBooks(@PathVariable String authentication_key){
        if (!jwtUserAuthenticationService.isUserAutheticated(authentication_key)){
            throw new CustomException("USER_NOT_AUTHENTICATION");
        }
        return new ResponseEntity<>(
                bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("{book_id}/{authentication_key}")
    public ResponseEntity<BookDTO> getBookByBookId(@PathVariable long book_id, @PathVariable String authentication_key){
        if (!jwtUserAuthenticationService.isUserAutheticated(authentication_key)){
            throw new CustomException("USER_NOT_AUTHENTICATION");
        }
        return new ResponseEntity<>(
                bookService.getBookByBookId(book_id), HttpStatus.OK
        );
    }
}
