package com.didactapp.server.api.v1.mapper;

import com.didactapp.server.api.v1.model.BookDTO;
import com.didactapp.server.domain.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapperImpl implements BookMapper {
    public BookDTO bookToBookDTO(Book book){
        if (book == null){
            return null;
        }
        BookDTO bookDTO = new BookDTO();
        bookDTO.setBookId(book.getBookId());
        bookDTO.setCoverUrl(book.getCoverUrl());
        bookDTO.setDescription(book.getDescription());
        bookDTO.setPublishedDate(book.getPublishedDate());
        bookDTO.setRevisionDate(book.getRevisionDate());
        bookDTO.setTagLine(book.getTagLine());
        bookDTO.setThumbnailUrl(book.getThumbnailUrl());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setVersion(book.getVersion());
        return bookDTO;
    }

}
