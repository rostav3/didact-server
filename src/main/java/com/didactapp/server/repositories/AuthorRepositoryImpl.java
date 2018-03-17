package com.didactapp.server.repositories;

import com.didactapp.server.domain.Author;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorRepositoryImpl implements AuthorRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Author> findAuthorsByBookId(long book_id) {
        Query query = entityManager.createNativeQuery("SELECT a.* FROM author a, book_author b WHERE b.author_id = a.author_id AND b.book_id=?", Author.class);
        query.setParameter(1, book_id);
        return query.getResultList();
    }
}
