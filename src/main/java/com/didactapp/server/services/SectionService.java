package com.didactapp.server.services;

import com.didactapp.server.api.v1.model.ChapterDTO;
import com.didactapp.server.api.v1.model.SectionDTO;

import java.util.List;

/**
 * Created by jt on 9/26/17.
 */
public interface SectionService {
    List<SectionDTO> getSectionsByChapterId(Integer chapter_id);
}
