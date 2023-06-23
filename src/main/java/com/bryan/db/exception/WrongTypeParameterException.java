package com.bryan.db.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "wrong type parameter")
public class WrongTypeParameterException extends RuntimeException {

    public WrongTypeParameterException(String message) {
        super(message);
    }
}
