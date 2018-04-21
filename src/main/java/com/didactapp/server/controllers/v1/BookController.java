package com.didactapp.server.controllers.v1;

import com.didactapp.server.api.v1.model.BookDTO;
import com.didactapp.server.services.BookService;
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

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("all")
    public ResponseEntity<List<BookDTO>> getallBooks(){

        return new ResponseEntity<List<BookDTO>>(
                bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("{book_id}")
    public ResponseEntity<BookDTO> getBookByBookId(@PathVariable long book_id){
        return new ResponseEntity<BookDTO>(
                bookService.getBookByBookId(book_id), HttpStatus.OK
        );
    }
}
