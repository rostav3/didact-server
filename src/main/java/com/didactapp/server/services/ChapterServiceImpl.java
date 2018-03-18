package com.didactapp.server.services;

import com.didactapp.server.api.v1.mapper.ChapterMapper;
import com.didactapp.server.api.v1.model.ChapterDTO;
import com.didactapp.server.domain.Chapter;
import com.didactapp.server.repositories.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jt on 9/26/17.
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

    @Override
    public List<ChapterDTO> getChaptersByBookId(Integer book_id) {
        List<Chapter> b = chapterRepository.findByBookId(book_id);
        Stream<Chapter> b2 = b.stream();
        Stream<ChapterDTO> b3 = b2.map(chapterMapper::chapterToChapterDTO);
        return b3.collect(Collectors.toList());
    }
}