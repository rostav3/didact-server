package com.didactapp.server.repositories;

import com.didactapp.server.domain.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by jt on 9/24/17.
 */
public interface ContentRepository extends JpaRepository<Content, Integer> {
    List<Content> findBySectionId(Integer section_id);
}
