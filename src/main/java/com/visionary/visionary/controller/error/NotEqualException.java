package com.visionary.visionary.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotEqualException extends RuntimeException{
    public NotEqualException(String message) {
        super(message);
    }
}
