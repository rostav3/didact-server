package com.didactapp.server.api.v1.mapper;
import com.didactapp.server.api.v1.model.BookDTO;
import com.didactapp.server.domain.Book;
import org.mapstruct.factory.Mappers;

/**
 * The interface is for a mapper from Book to BookDTO
 */

public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDTO bookToBookDTO(Book book);

}
