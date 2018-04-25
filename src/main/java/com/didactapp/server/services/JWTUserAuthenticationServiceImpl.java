package com.didactapp.server.services;

import com.didactapp.server.domain.JwtKeys;
import com.didactapp.server.repositories.JwtKeysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The service class of the authentication key (for each api, except the authentication api).
 */

@Service
public class JWTUserAuthenticationServiceImpl implements JWTUserAuthenticationService {

    @Autowired
    private JwtKeysRepository jwtKeysRepository;

    public void setJwtKeysRepository(JwtKeysRepository jwtKeysRepository) {
        this.jwtKeysRepository = jwtKeysRepository;
    }

    /**
     * check if the authorization_key exists
     * @param authorization_key - the authorization_key
     * @return true if exist, else false.
     */
    public boolean isUserAutheticated(String authorization_key) {
        JwtKeys jwtKeys = jwtKeysRepository.findAuthorsByAuthorizationKey(authorization_key);
        return (jwtKeys != null);
    }


}