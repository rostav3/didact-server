package com.didactapp.server.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The class represent the User entity
 */

@Table(name = "user_data")
@Entity
public class User {
    @Id
    private String email;
    private String password;
    public User() {
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
