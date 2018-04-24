package com.didactapp.server.api.v1.mapper;
import com.didactapp.server.api.v1.model.AuthorDTO;
import com.didactapp.server.domain.Author;
import org.mapstruct.factory.Mappers;

/**
 * The interface is for a mapper from Author to AuthorDTO
 */
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);
    AuthorDTO authorToAuthorDTO(Author author);
}
