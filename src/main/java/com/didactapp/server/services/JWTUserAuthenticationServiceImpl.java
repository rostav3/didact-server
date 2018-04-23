package com.didactapp.server.services;

import com.didactapp.server.domain.JwtKeys;
import com.didactapp.server.repositories.JwtKeysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jt on 9/26/17.
 */
@Service
public class JWTUserAuthenticationServiceImpl implements JWTUserAuthenticationService {

    @Autowired
    private JwtKeysRepository jwtKeysRepository;

    public void setJwtKeysRepository(JwtKeysRepository jwtKeysRepository) {
        this.jwtKeysRepository = jwtKeysRepository;
    }

    public boolean isUserAutheticated(String authorization_key) {
        JwtKeys jwtKeys = jwtKeysRepository.findAuthorsByAuthorizationKey(authorization_key);
        return (jwtKeys != null);
    }


}