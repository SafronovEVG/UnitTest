package com.example.junit_test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoParametersException extends NullPointerException {

    public NoParametersException(String message) {
        super(message);
    }

    public NoParametersException() {
    }
}
