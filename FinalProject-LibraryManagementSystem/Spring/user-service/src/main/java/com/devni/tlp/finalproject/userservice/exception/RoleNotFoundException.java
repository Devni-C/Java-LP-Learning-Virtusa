package com.devni.tlp.finalproject.userservice.exception;

public class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException() {}

    public RoleNotFoundException(String message){
        super(message);
    }

    public RoleNotFoundException(String message, Throwable rootCause) {
        super(message, rootCause);
    }
}
