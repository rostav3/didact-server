package com.didactapp.server.controllers.v1;

import com.didactapp.server.api.v1.model.ContentListDTO;
import com.didactapp.server.services.ContentService;
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
@RequestMapping("/api/v1/contents/")
public class ContentController {

    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping("sections/{section_id}")
    public ResponseEntity<ContentListDTO> getContentsBySectionId(@PathVariable Integer section_id){

        return new ResponseEntity<>(
                new ContentListDTO(contentService.getContentsBySectionId(section_id)), HttpStatus.OK);
    }
}