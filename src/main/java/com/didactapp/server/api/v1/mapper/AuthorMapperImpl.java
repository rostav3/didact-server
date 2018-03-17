package com.didactapp.server.api.v1.mapper;

import com.didactapp.server.api.v1.model.AuthorDTO;
import com.didactapp.server.domain.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapperImpl implements AuthorMapper {
    @Override
    public AuthorDTO authorToAuthorDTO(Author author) {
        if (author == null){
            return null;
        }
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setAbout(author.getAbout());
        authorDTO.setAuthorId(author.getAuthorId());
        authorDTO.setFirstName(author.getFirstName());
        authorDTO.setLastName(author.getLastName());
        return authorDTO;
    }

}
