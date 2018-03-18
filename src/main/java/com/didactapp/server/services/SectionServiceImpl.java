package com.didactapp.server.services;

import com.didactapp.server.api.v1.mapper.SectionMapper;
import com.didactapp.server.api.v1.model.SectionDTO;
import com.didactapp.server.domain.Section;
import com.didactapp.server.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jt on 9/26/17.
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

    @Override
    public List<SectionDTO> getSectionsByChapterId(Integer chapter_id) {
        List<Section> b = sectionRepository.findByChapterId(chapter_id);
        Stream<Section> b2 = b.stream();
        Stream<SectionDTO> b3 = b2.map(sectionMapper::sectionToSectionDTO);
        return b3.collect(Collectors.toList());
    }
}