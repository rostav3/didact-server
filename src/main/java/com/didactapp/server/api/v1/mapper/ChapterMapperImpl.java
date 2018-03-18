package com.didactapp.server.api.v1.mapper;

import com.didactapp.server.api.v1.model.ChapterDTO;
import com.didactapp.server.domain.Chapter;
import org.springframework.stereotype.Component;

@Component
public class ChapterMapperImpl implements ChapterMapper {
    @Override
    public ChapterDTO chapterToChapterDTO(Chapter chapter) {
        if (chapter == null){
            return null;
        }
        ChapterDTO chapterDTO = new ChapterDTO();
        chapterDTO.setBookId(chapter.getBookId());
        chapterDTO.setChapterId(chapter.getChapterId());
        chapterDTO.setChapterNum(chapter.getChapterNum());
        chapterDTO.setDescription(chapter.getDescription());
        chapterDTO.setThumbnailUrl(chapter.getThumbnailUrl());
        return chapterDTO;
    }
}
