package com.devni.tlp.finalproject.bookservice.exception;

public class BookNotAvailableException extends Exception {
    public BookNotAvailableException() {}

    public BookNotAvailableException(String message) {
        super(message);
    }

    public BookNotAvailableException(String message, Throwable rootCause) {
        super(message, rootCause);
    }
}
