package com.devni.tlp.finalproject.reservationservice.service;

import com.devni.tlp.finalproject.reservationservice.model.Lending;
import com.devni.tlp.finalproject.reservationservice.model.Reservation;
import com.devni.tlp.finalproject.reservationservice.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    /**
     * save new book reservation
     * @param reservation
     * @return
     */
    @Override
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    /**
     * fetch reserved book by userID
     * @param uid
     * @return
     */
    @Override
    public List<Reservation> getReservationsByBookId(int uid) {
        return reservationRepository.findAll().stream()
                .filter(reservation -> reservation.getUser().getId() == uid)
                .collect(Collectors.toList());
    }

//    @Override
//    public List<Reservation> getReservationsByBookId(int id) {
//        return reservationRepository.get
//    }
}
