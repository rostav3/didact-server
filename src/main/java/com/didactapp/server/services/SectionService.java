package com.didactapp.server.services;

import com.didactapp.server.api.v1.model.SectionDTO;

import java.util.List;

/**
 * The interface service in the section api.
 */
public interface SectionService {
    List<SectionDTO> getSectionsByChapterId(int chapter_id);
}
