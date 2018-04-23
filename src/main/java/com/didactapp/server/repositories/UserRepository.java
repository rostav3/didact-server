package com.didactapp.server.repositories;

import com.didactapp.server.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jt on 9/24/17.
 */
public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
}
