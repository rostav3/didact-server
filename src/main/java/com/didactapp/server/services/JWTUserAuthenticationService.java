package com.didactapp.server.services;

/**
 * Created by jt on 9/26/17.
 */
public interface JWTUserAuthenticationService {
    boolean isUserAutheticated(String authorization_key);


}
