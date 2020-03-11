package com.devni.tlp.finalproject.reservationservice.service;

import com.devni.tlp.finalproject.reservationservice.model.Reservation;

public interface ReservationService {
    Reservation getReservationsByBookId(int id);


}
