package com.devni.tlp.finalproject.bookservice.exception;

public class BookExistException extends Exception {
    public BookExistException() {}

    public BookExistException(String message) {
        super(message);
    }

    public BookExistException(String message, Throwable rootCause) {
        super(message, rootCause);
    }
}
