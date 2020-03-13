package com.devni.tlp.finalproject.reservationservice.service;

import com.devni.tlp.finalproject.reservationservice.model.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation saveReservation(Reservation reservation);

    Reservation fetchReservationById(Integer id);

    List<Reservation> fetchAllReservations();

    List<Reservation> fetchReservationsByBookId(Integer bookId);

    List<Reservation> fetchReservationsByUserId(Integer userId);

}
