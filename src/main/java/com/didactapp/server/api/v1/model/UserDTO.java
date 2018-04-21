package com.didactapp.server.api.v1.model;

/**
 * Created by jt on 9/24/17.
 */
public class UserDTO {
    private String userKey;
    private String key;

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
