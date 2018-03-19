package com.didactapp.server.controllers.v1;

import com.didactapp.server.api.v1.model.SectionListDTO;
import com.didactapp.server.services.SectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jt on 9/26/17.
 */
@Controller
@RequestMapping("/api/v1/sections/")
public class SectionController {

    private final SectionService sectionService;

    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @GetMapping("chapters/{chapter_id}")
    public ResponseEntity<SectionListDTO> getSectionsByChapterId(@PathVariable Integer chapter_id){

        return new ResponseEntity<>(
                new SectionListDTO(sectionService.getSectionsByChapterId(chapter_id)), HttpStatus.OK);
    }
}