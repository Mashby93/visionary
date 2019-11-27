package com.visionary.visionary.controller.error;

public class BannedException extends RuntimeException {
    public BannedException() {
        super("This account has been banned, an email has been dispatched with details");
    }
}
