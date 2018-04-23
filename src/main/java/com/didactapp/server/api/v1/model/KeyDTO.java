package com.didactapp.server.api.v1.model;

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
