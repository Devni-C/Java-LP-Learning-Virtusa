package com.devni.tlp.finalproject.reservationservice.service;

import com.devni.tlp.finalproject.reservationservice.model.Reservation;
import com.devni.tlp.finalproject.reservationservice.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public Reservation getReservationsByBookId(int id) {
        return null;
    }

//    @Override
//    public List<Reservation> getReservationsByBookId(int id) {
//        return reservationRepository.get
//    }
}
