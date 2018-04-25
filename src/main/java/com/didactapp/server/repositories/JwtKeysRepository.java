package com.didactapp.server.repositories;

import com.didactapp.server.domain.JwtKeys;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * The interface connection with the jwt_keys table in db
 */
@Transactional
public interface JwtKeysRepository extends JpaRepository<JwtKeys, String> {

    JwtKeys findAuthorsByAuthorizationKey(String authorization_key);

}
