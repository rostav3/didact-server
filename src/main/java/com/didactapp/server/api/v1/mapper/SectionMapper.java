package com.didactapp.server.api.v1.mapper;
import com.didactapp.server.api.v1.model.SectionDTO;
import com.didactapp.server.domain.Section;
import org.mapstruct.factory.Mappers;

/**
 * The interface is for a mapper from Section to SectionDTO
 */
public interface SectionMapper {
    SectionMapper INSTANCE = Mappers.getMapper(SectionMapper.class);

    SectionDTO sectionToSectionDTO(Section section);
}
