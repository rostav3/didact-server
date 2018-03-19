package com.didactapp.server.api.v1.mapper;

import com.didactapp.server.api.v1.model.ContentDTO;
import com.didactapp.server.domain.Content;
import org.springframework.stereotype.Component;

@Component
public class ContentMapperImpl implements ContentMapper {
    @Override
    public ContentDTO contentToContentDTO(Content content) {
        if (content == null){
            return null;
        }
        ContentDTO contentDTO = new ContentDTO();
        contentDTO.setContentId(content.getContnetId());
        contentDTO.setContentNum(content.getContentNum());
        contentDTO.setContentUrl(content.getContent_url());
        contentDTO.setSectionId(content.getSectionId());
        contentDTO.setType(content.getType());
        return contentDTO;
    }
}
