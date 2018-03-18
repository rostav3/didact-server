package com.didactapp.server.api.v1.model;

import lombok.Data;

import java.util.List;

/**
 * Created by jt on 9/26/17.
 */
@Data
public class BookListDTO {
    private List<BookDTO> books;

    public BookListDTO(List<BookDTO> books) {
        this.books = books;
    }

    public List<BookDTO> getBooks() {
        return books;
    }
}
