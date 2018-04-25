package com.didactapp.server.repositories;

import com.didactapp.server.domain.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The interface connection with the section table in db
 */
public interface SectionRepository extends JpaRepository<Section, Integer> {
    List<Section> findByChapterId(int chapter_id);
}
