package com.didactapp.server.api.v1.mapper;
import com.didactapp.server.api.v1.model.ChapterDTO;
import com.didactapp.server.api.v1.model.SectionDTO;
import com.didactapp.server.domain.Chapter;
import com.didactapp.server.domain.Section;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SectionMapper {
    SectionMapper INSTANCE = Mappers.getMapper(SectionMapper.class);

    SectionDTO sectionToSectionDTO(Section section);
}
