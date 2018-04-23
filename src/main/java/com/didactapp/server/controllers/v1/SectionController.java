package com.didactapp.server.controllers.v1;

import com.didactapp.server.api.v1.model.SectionDTO;
import com.didactapp.server.error.CustomException;
import com.didactapp.server.services.JWTUserAuthenticationService;
import com.didactapp.server.services.SectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by jt on 9/26/17.
 */
@Controller
@RequestMapping("/api/v1/sections/")
public class SectionController {

    private final SectionService sectionService;
    private final JWTUserAuthenticationService jwtUserAuthenticationService;

    public SectionController(SectionService sectionService, JWTUserAuthenticationService jwtUserAuthenticationService) {
        this.sectionService = sectionService;
        this.jwtUserAuthenticationService = jwtUserAuthenticationService;
    }

    @GetMapping("chapters/{chapter_id}/{authentication_key}")
    public ResponseEntity<List<SectionDTO>> getSectionsByChapterId(@PathVariable int chapter_id, @PathVariable String authentication_key){
        if (!jwtUserAuthenticationService.isUserAutheticated(authentication_key)) {
            throw new CustomException("USER_NOT_AUTHENTICATION");
        }

        return new ResponseEntity<>(
                sectionService.getSectionsByChapterId(chapter_id), HttpStatus.OK);
    }
}