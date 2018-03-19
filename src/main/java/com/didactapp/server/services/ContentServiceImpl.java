package com.didactapp.server.services;

import com.didactapp.server.api.v1.mapper.ContentMapper;
import com.didactapp.server.api.v1.model.ContentDTO;
import com.didactapp.server.repositories.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jt on 9/26/17.
 */
@Service
public class ContentServiceImpl implements ContentService {

    private ContentMapper contentMapper;
    private ContentRepository contentRepository;

    @Autowired
    public void setContentMapper(ContentMapper contentMapper) {
        this.contentMapper = contentMapper;
    }

    @Autowired
    public void setContentRepository(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @Override
    public List<ContentDTO> getContentsBySectionId(Integer section_id) {
        return contentRepository.findBySectionId(section_id).stream().map(contentMapper::contentToContentDTO).collect(Collectors.toList());
    }

}