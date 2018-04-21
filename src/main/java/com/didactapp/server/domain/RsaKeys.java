package com.didactapp.server.domain;

import javax.persistence.*;

@Table(name = "rsa_keys")
@Entity
public class RsaKeys {
    @Id
    private String publicKey;

    private String privateKey;


    public RsaKeys() {
    }

    @Column(name="public_key")
    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    @Column(name="private_key")
    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }
}
