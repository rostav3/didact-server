package com.didactapp.server.controllers.v1;

import com.didactapp.server.api.v1.model.ChapterDTO;
import com.didactapp.server.error.CustomException;
import com.didactapp.server.services.ChapterService;
import com.didactapp.server.services.JWTUserAuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * The class represent the api of the chapters
 */

@Controller
@RequestMapping("/api/v1/chapters/")
public class ChapterController {

    private final ChapterService chapterService;
    private final JWTUserAuthenticationService jwtUserAuthenticationService;


    public ChapterController(ChapterService chapterService, JWTUserAuthenticationService jwtUserAuthenticationService) {
        this.chapterService = chapterService;
        this.jwtUserAuthenticationService = jwtUserAuthenticationService;
    }

    /**
     * The get call of all the chapters of a book.
     * @param book_id - The book we want to get is chapters
     * @param authentication_key - code for authenticate the user
     * @return list of the chapters book
     */
    @GetMapping("books/{book_id}/{authentication_key}")
    public ResponseEntity<List<ChapterDTO>> getChaptersByBookId(@PathVariable int book_id,
                                                                @PathVariable String authentication_key){
        if (!jwtUserAuthenticationService.isUserAutheticated(authentication_key)){
            throw new CustomException("USER_NOT_AUTHENTICATION");
        }
        return new ResponseEntity<>(chapterService.getChaptersByBookId(book_id), HttpStatus.OK);
    }
}