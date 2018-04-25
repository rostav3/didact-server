package com.didactapp.server.services;

/**
 * The interface service of the authentication key (for each api, except the authentication api).
 */
public interface JWTUserAuthenticationService {
    boolean isUserAutheticated(String authorization_key);


}
