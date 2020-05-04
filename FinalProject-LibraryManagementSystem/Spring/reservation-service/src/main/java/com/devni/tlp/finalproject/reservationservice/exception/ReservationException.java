package com.devni.tlp.finalproject.reservationservice.exception;

public class ReservationException extends Exception {
    public ReservationException() {
    }

    public ReservationException(String message) {
        super(message);
    }

    public ReservationException(String message, Throwable rootCause) {
        super(message, rootCause);
    }
}
