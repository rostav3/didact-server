package com.didactapp.server.controllers.v1;

import com.didactapp.server.api.v1.model.ChapterListDTO;
import com.didactapp.server.services.ChapterService;
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
@RequestMapping("/api/v1/chapters/")
public class ChapterController {

    private final ChapterService chapterService;

    public ChapterController(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @GetMapping("books/{book_id}")
    public ResponseEntity<ChapterListDTO> getChaptersByBookId(@PathVariable Integer book_id){

        return new ResponseEntity<>(
                new ChapterListDTO(chapterService.getChaptersByBookId(book_id)), HttpStatus.OK);
    }
}