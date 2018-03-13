package com.didactapp.server.api.v1.mapper;
import com.didactapp.server.api.v1.model.BookDTO;
import com.didactapp.server.domain.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDTO bookToBookDTO(Book book);

}
