package com.didactapp.server.api.v1.mapper;

import com.didactapp.server.api.v1.model.SectionDTO;
import com.didactapp.server.domain.Section;
import org.springframework.stereotype.Component;

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
        return sectionDTO;
    }
}
