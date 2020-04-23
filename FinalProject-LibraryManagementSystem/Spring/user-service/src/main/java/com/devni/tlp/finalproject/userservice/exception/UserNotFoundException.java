package com.devni.tlp.finalproject.userservice.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {}

    public UserNotFoundException(String message) {
        super(message);
    }
    public UserNotFoundException(String message, Throwable rootCause) {
        super(message, rootCause);
    }
}
