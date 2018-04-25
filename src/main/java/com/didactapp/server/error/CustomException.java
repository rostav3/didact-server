package com.didactapp.server.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * The class represent the custom exception, that throw when something unexpected append in the server
 */

@ResponseStatus(value= HttpStatus.UNAUTHORIZED)
public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
