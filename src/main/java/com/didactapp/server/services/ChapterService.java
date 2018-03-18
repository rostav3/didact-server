package com.didactapp.server.services;

import com.didactapp.server.api.v1.model.ChapterDTO;

import java.util.List;

/**
 * Created by jt on 9/26/17.
 */
public interface ChapterService {
    List<ChapterDTO> getChaptersByBookId(Integer book_id);
}
