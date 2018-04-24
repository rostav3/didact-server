package com.didactapp.server.api.v1.mapper;

import com.didactapp.server.api.v1.model.SectionDTO;
import com.didactapp.server.domain.Section;
import org.springframework.stereotype.Component;

/**
 * The class is a mapper from Section to SectionDTO
 */

@Component
public class SectionMapperImpl implements SectionMapper {
    @Override
    public SectionDTO sectionToSectionDTO(Section section) {
        if (section == null){
            return null;
        }
        SectionDTO sectionDTO = new SectionDTO();
        sectionDTO.setChapterId(section.getChapterId());
        sectionDTO.setSectionId(section.getSectionId());
        sectionDTO.setSectionNum(section.getSectionNum());
        sectionDTO.setCorrectAnswer(section.getCorrectAnswer());
        sectionDTO.setExplanation(section.getExplanation());
        sectionDTO.setImageUrl(section.getImageUrl());
        sectionDTO.setName(section.getName());
        sectionDTO.setQuestion(section.getQuestion());
        sectionDTO.setWrongAnswer1(section.getWrongAnswer1());
        sectionDTO.setWrongAnswer2(section.getWrongAnswer2());
        sectionDTO.setWrongAnswer3(section.getWrongAnswer3());
        return sectionDTO;
    }
}
