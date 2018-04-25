package com.didactapp.server.services;

import com.didactapp.server.api.v1.mapper.SectionMapper;
import com.didactapp.server.api.v1.model.SectionDTO;
import com.didactapp.server.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The service class in the section api.
 */
@Service
public class SectionServiceImpl implements SectionService {

    private SectionMapper sectionMapper;
    private SectionRepository sectionRepository;

    @Autowired
    public void setSectionMapper(SectionMapper sectionMapper) {
        this.sectionMapper = sectionMapper;
    }

    @Autowired
    public void setSectionRepository(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    /**
     * return all the sections in a chapter
     * @param chapter_id - the chapter that we get is sectionss.
     * @return list of all the sections
     */
    @Override
    public List<SectionDTO> getSectionsByChapterId(int chapter_id) {
        return sectionRepository.findByChapterId(chapter_id).stream().map(sectionMapper::sectionToSectionDTO).collect(Collectors.toList());
    }
}