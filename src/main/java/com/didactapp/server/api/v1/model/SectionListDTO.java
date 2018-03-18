package com.didactapp.server.api.v1.model;

import lombok.Data;

import java.util.List;

/**
 * Created by jt on 9/26/17.
 */
@Data
public class SectionListDTO {
    private List<SectionDTO> sections;

    public SectionListDTO(List<SectionDTO> sections) {
        this.sections = sections;
    }
    public List<SectionDTO> getSections() {
        return sections;
    }


}
