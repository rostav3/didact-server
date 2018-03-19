package com.didactapp.server.api.v1.model;

import lombok.Data;

import java.util.List;

/**
 * Created by jt on 9/26/17.
 */
@Data
public class ContentListDTO {
    private List<ContentDTO> contents;

    public ContentListDTO(List<ContentDTO> contents) {
        this.contents = contents;
    }

    public List<ContentDTO> getContents() {
        return contents;
    }
}
