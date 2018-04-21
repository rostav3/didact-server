package com.didactapp.server.repositories;

import com.didactapp.server.domain.RsaKeys;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by jt on 9/24/17.
 */
@Transactional
public interface RsaKeysRepository extends CrudRepository<RsaKeys, String> {
    RsaKeys findByPublicKey(String book_id);
}
