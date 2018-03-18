package com.didactapp.server.api.v1.mapper;
import com.didactapp.server.api.v1.model.ChapterDTO;
import com.didactapp.server.domain.Chapter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChapterMapper {
    ChapterMapper INSTANCE = Mappers.getMapper(ChapterMapper.class);

    ChapterDTO chapterToChapterDTO(Chapter chapter);
}
