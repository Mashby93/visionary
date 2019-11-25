package com.visionary.visionary.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidTimeException extends RuntimeException{
    public InvalidTimeException(String message) {
        super(message);
    }
}
