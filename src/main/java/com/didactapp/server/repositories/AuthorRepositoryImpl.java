package com.didactapp.server.repositories;

import com.didactapp.server.domain.Author;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * The class represent the author repository implementation that do the not usual queries.
 */
@Repository
@Transactional
public class AuthorRepositoryImpl implements AuthorRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * The method return all the authors of a book from the db.
     * @param book_id - The book we want is authors.
     * @return list of authors.
     */
    @Override
    public List<Author> findAuthorsByBookId(long book_id) {
        Query query = entityManager.createNativeQuery("SELECT a.* FROM author a, book_author b WHERE b.author_id = a.author_id AND b.book_id=?", Author.class);
        query.setParameter(1, book_id);
        return query.getResultList();
    }
}
