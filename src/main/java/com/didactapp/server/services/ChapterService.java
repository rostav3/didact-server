package com.didactapp.server.services;

import com.didactapp.server.api.v1.model.ChapterDTO;

import java.util.List;

/**
 * The interface service in the chapter api.
 */
public interface ChapterService {
    List<ChapterDTO> getChaptersByBookId(int book_id);
}
