package com.devni.tlp.finalproject.reservationservice.exception;

public class LendingNotSavedException extends Exception {
    public LendingNotSavedException() {
    }

    public LendingNotSavedException(String message) {
        super(message);
    }

    public LendingNotSavedException(String message, Throwable rootCause) {
        super(message, rootCause);
    }}
