package com.devni.tlp.finalproject.reservationservice.controller;

import com.devni.tlp.finalproject.reservationservice.model.Reservation;
import com.devni.tlp.finalproject.reservationservice.repository.ReservationRepository;
import com.devni.tlp.finalproject.reservationservice.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reserve")
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Reservation save(@RequestBody Reservation reservation) {
        return reservationService.saveReservation(reservation);
    }


//    isAvailable,
}
