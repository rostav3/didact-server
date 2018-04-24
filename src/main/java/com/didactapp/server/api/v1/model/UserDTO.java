package com.didactapp.server.api.v1.model;

/**
 * The class represent the UserDTO (Data transfer object) - the User object for communicate with the client
 */
public class UserDTO {
    private String userKey;
    private String key; // The public key that used for encrypt the userKey.

    public UserDTO() {
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
