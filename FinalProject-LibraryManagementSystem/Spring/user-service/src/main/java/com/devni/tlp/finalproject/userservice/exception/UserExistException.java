package com.devni.tlp.finalproject.userservice.exception;

public class UserExistException extends Throwable {
    public UserExistException(){}

    public UserExistException(String message) {
        super(message);
    }

    public UserExistException(String message, Throwable rootCause) {
        super(message, rootCause);
    }
}
