package com.didactapp.server.repositories;

import com.didactapp.server.domain.RsaKeys;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * The interface connection with the rsa_keys table in db
 */
@Transactional
public interface RsaKeysRepository extends JpaRepository<RsaKeys, String> {
    RsaKeys findByPublicKey(String book_id);
}
