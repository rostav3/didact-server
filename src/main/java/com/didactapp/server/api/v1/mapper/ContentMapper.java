package com.didactapp.server.api.v1.mapper;
import com.didactapp.server.api.v1.model.ContentDTO;
import com.didactapp.server.domain.Content;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContentMapper {
    ContentMapper INSTANCE = Mappers.getMapper(ContentMapper.class);

    ContentDTO contentToContentDTO(Content content);

}
