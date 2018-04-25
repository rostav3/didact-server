package com.didactapp.server.services;

import com.didactapp.server.api.v1.mapper.ChapterMapper;
import com.didactapp.server.api.v1.model.ChapterDTO;
import com.didactapp.server.repositories.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The service class in the chapter api.
 */

@Service
public class ChapterServiceImpl implements ChapterService {

    private ChapterMapper chapterMapper;
    private ChapterRepository chapterRepository;

    @Autowired
    public void setChapterMapper(ChapterMapper chapterMapper) {
        this.chapterMapper = chapterMapper;
    }

    @Autowired
    public void setChapterRepository(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }

    /**
     * return all the chapters in a book
     * @param book_id - the book that we get is chapters.
     * @return list of all the chapters
     */
    @Override
    public List<ChapterDTO> getChaptersByBookId(int book_id) {
        return chapterRepository.findByBookId(book_id).stream().map(chapterMapper::chapterToChapterDTO).collect(Collectors.toList());
    }
}