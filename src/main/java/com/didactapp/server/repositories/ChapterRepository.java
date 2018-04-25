package com.didactapp.server.repositories;

import com.didactapp.server.domain.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The interface connection with the chapter table in db
 */
public interface ChapterRepository extends JpaRepository<Chapter, Integer> {
    List<Chapter> findByBookId(int book_id);
}
