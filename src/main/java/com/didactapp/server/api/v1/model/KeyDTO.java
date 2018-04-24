package com.didactapp.server.api.v1.model;

/**
 * The class represent the KeyDTO (Data transfer object) - the Key object for communicate with the client
 */

public class KeyDTO {
    private String key;

    public KeyDTO(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
