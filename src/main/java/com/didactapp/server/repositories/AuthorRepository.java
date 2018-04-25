package com.didactapp.server.repositories;

import com.didactapp.server.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface connection with the author table in db
 */
public interface AuthorRepository extends JpaRepository<Author, Long>, AuthorRepositoryCustom {
}