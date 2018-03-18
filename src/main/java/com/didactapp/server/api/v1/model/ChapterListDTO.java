package com.didactapp.server.api.v1.model;

import lombok.Data;

import java.util.List;

/**
 * Created by jt on 9/26/17.
 */
@Data
public class ChapterListDTO {
    private List<ChapterDTO> chapters;

    public ChapterListDTO(List<ChapterDTO> chapters) {
        this.chapters = chapters;
    }
    public List<ChapterDTO> getChapters() {
        return chapters;
    }


}
