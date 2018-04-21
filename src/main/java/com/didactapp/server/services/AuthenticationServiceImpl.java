package com.didactapp.server.services;

import com.didactapp.server.api.v1.model.UserDTO;
import com.didactapp.server.domain.JwtKeys;
import com.didactapp.server.domain.RsaKeys;
import com.didactapp.server.domain.User;
import com.didactapp.server.error.CustomException;
import com.didactapp.server.repositories.JwtKeysRepository;
import com.didactapp.server.repositories.RsaKeysRepository;
import com.didactapp.server.repositories.UserRepository;
import com.google.gson.Gson;
import com.nimbusds.jose.crypto.RSADecrypter;
import com.nimbusds.jwt.EncryptedJWT;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;

/**
 * Created by jt on 9/26/17.
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private RsaKeysRepository rsaKeysRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtKeysRepository jwtKeysRepository;

    public void setJwtKeysRepository(JwtKeysRepository jwtKeysRepository) {
        this.jwtKeysRepository = jwtKeysRepository;
    }

    public void setRsaKeysRepository(RsaKeysRepository rsaKeysRepository) {
        this.rsaKeysRepository = rsaKeysRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @SuppressWarnings("AssignmentToMethodParameter")
    @Transactional
    @Override
    public String getNewPublicKey() {
        KeyPairGenerator keyPairGenerator;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(1024);

            // generate the key pair
            KeyPair keyPair = keyPairGenerator.genKeyPair();

            // create KeyFactory and RSA Keys Specs
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            RSAPublicKeySpec publicKeySpec = keyFactory.getKeySpec(keyPair.getPublic(), RSAPublicKeySpec.class);
            RSAPrivateKeySpec privateKeySpec = keyFactory.getKeySpec(keyPair.getPrivate(), RSAPrivateKeySpec.class);

            // generate (and retrieve) RSA Keys from the KeyFactory using Keys Specs
            RSAPublicKey publicRsaKey = (RSAPublicKey) keyFactory.generatePublic(publicKeySpec);
            RSAPrivateKey privateRsaKey  = (RSAPrivateKey) keyFactory.generatePrivate(privateKeySpec);

            RsaKeys rsaKeys = new RsaKeys();
            rsaKeys.setPrivateKey(Base64.getEncoder().encodeToString(privateRsaKey.getEncoded()));
            rsaKeys.setPublicKey(Base64.getEncoder().encodeToString(publicRsaKey.getEncoded()));
            rsaKeysRepository.save(rsaKeys);
            return rsaKeys.getPublicKey();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new CustomException(e.getMessage());
        }
    }

    @SuppressWarnings("AssignmentToMethodParameter")
    @Transactional
    @Override
    public String signUp(UserDTO userDTO) {
        try {
            if (userDTO == null){
                throw new CustomException("USER_DATA_EMPTY");
            }
            User user = getUserFromDTO(userDTO);

            if (isUserExist(user)){
                throw new CustomException("USER_EXISTS");
            }
            userRepository.save(user);
            JwtKeys jwtKeys = getAuthorizationKey(user);
            jwtKeysRepository.save(jwtKeys);
            return jwtKeys.getAuthorizationKey();
        }catch (Exception e){
            throw new CustomException(e.getMessage());
        }
    }

    @SuppressWarnings("AssignmentToMethodParameter")
    @Transactional
    @Override
    public String signIn(UserDTO userDTO) {
        try {
            if (userDTO == null){
                throw new CustomException("USER_DATA_EMPTY");
            }
            User user = getUserFromDTO(userDTO);
            User userRealData = userRepository.findByEmail(user.getEmail());
            if (userRealData == null){
                throw new CustomException("USER_NOT_EXISTS");
            }
            if (!userRealData.getPassword().equals(user.getPassword())){
                throw new CustomException("PASSWORD_INCORRECT");
            }

            JwtKeys jwtKeys = getAuthorizationKey(user);
            jwtKeysRepository.save(jwtKeys);
            return jwtKeys.getAuthorizationKey();
        }catch (Exception e){
            throw new CustomException(e.getMessage());
        }
    }

    private JwtKeys getAuthorizationKey(User user){
        Key key = MacProvider.generateKey();
        String compactJws = Jwts.builder().setSubject(user.getEmail()).signWith(SignatureAlgorithm.HS512, key).compact();
        JwtKeys keys = new JwtKeys();
        keys.setJwtKey(Base64.getEncoder().encodeToString(key.getEncoded()));
        keys.setAuthorizationKey(compactJws);
        return keys;
    }

    private boolean isUserExist(User user) {
        User userData = userRepository.findByEmail(user.getEmail());
        return (userData != null);
    }

    private User getUserFromDTO(UserDTO userDTO) throws Exception {
        RsaKeys rsaKeys = rsaKeysRepository.findByPublicKey(userDTO.getKey());
        if (rsaKeys == null) {
            throw new CustomException("PUBLIC_KEY_UNKNOWN");
        }

        RSAPrivateKey privateRsaKey = getRsaPrivateKey(rsaKeys.getPrivateKey());
        if (privateRsaKey == null){
            throw new CustomException("RSA_KEYS_ERROR");
        }
        EncryptedJWT jwt = EncryptedJWT.parse(userDTO.getUserKey());
        RSADecrypter decrypter = new RSADecrypter(privateRsaKey);
        jwt.decrypt(decrypter);

        Gson gson = new Gson();
        User user = gson.fromJson(jwt.getJWTClaimsSet().getSubject(), User.class);

        if ((user == null) || (user.getPassword().equals("null")) || (user.getEmail().equals("null"))) {
            throw new CustomException("USER_DATA_INCORRECT");
        }

        user.setPassword(getPasswordMD5(user.getPassword()));
        user.setEmail(user.getEmail().toLowerCase());
        return user;
    }

    private String getPasswordMD5(String password) throws Exception{
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        return DatatypeConverter.printHexBinary(digest).toUpperCase();
    }

    private RSAPrivateKey getRsaPrivateKey(String privateKey) throws Exception{
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec keySpecPKCS8 = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey));
        return (RSAPrivateKey) kf.generatePrivate(keySpecPKCS8);
    }
}