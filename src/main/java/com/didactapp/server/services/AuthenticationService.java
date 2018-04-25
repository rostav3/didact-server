package com.didactapp.server.services;

import com.didactapp.server.api.v1.model.UserDTO;

/**
 * The interface service in the authentication api.
 */
public interface AuthenticationService {
    String getNewPublicKey();
    String signUp(UserDTO userDTO);
    String signIn(UserDTO userDTO);


}
