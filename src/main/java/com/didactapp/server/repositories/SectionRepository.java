package com.didactapp.server.repositories;

import com.didactapp.server.domain.Chapter;
import com.didactapp.server.domain.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by jt on 9/24/17.
 */
public interface SectionRepository extends JpaRepository<Section, Integer> {
    List<Section> findByChapterId(Integer chapter_id);
}
