package com.didactapp.server.repositories;

import com.didactapp.server.domain.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by jt on 9/24/17.
 */
public interface ChapterRepository extends JpaRepository<Chapter, Integer> {
    List<Chapter> findByBookId(int book_id);
}
