package com.didactapp.server.services;

import com.didactapp.server.api.v1.model.ContentDTO;

import java.util.List;

/**
 * Created by jt on 9/26/17.
 */
public interface ContentService {
    List<ContentDTO> getContentsBySectionId(Integer section_id);
}
