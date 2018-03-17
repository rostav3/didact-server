package com.didactapp.server.api.v1.mapper;
import com.didactapp.server.api.v1.model.AuthorDTO;
import com.didactapp.server.domain.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorDTO authorToAuthorDTO(Author author);

}
