package com.devni.tlp.finalproject.reservationservice.service;

import com.devni.tlp.finalproject.reservationservice.model.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> getReservationsByBookId(int id);

    Reservation saveReservation(Reservation reservation);
}
