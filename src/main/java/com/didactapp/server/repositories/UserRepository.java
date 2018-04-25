package com.didactapp.server.repositories;

import com.didactapp.server.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface connection with the user_data table in db
 */
public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
}
