package com.didactapp.server.api.v1.model;

import java.util.List;

/**
 * Created by jt on 9/26/17.
 */
public class ChapterListDTO {
    private List<ChapterDTO> chapters;

    public ChapterListDTO(List<ChapterDTO> chapters) {
        this.chapters = chapters;
    }
    public List<ChapterDTO> getChapters() {
        return chapters;
    }


}
