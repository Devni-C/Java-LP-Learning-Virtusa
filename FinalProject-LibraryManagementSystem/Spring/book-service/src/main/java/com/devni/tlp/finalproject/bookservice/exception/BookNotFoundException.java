package com.devni.tlp.finalproject.bookservice.exception;

public class BookNotFoundException extends Exception {
    public BookNotFoundException() {}

    public BookNotFoundException(String message) {
        super(message);
    }

    public BookNotFoundException(String message, Throwable rootCause) {
        super(message, rootCause);
    }
}
