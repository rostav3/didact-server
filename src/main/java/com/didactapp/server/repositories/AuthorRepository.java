package com.didactapp.server.repositories;

import com.didactapp.server.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jt on 9/24/17.
 */
public interface AuthorRepository extends JpaRepository<Author, Long>, AuthorRepositoryCustom {
}
