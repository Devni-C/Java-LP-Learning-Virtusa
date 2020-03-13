package com.devni.tlp.finalproject.reservationservice.controller;

import com.devni.tlp.finalproject.reservationservice.model.Reservation;
import com.devni.tlp.finalproject.reservationservice.repository.ReservationRepository;
import com.devni.tlp.finalproject.reservationservice.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/reserve")
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Reservation save(@RequestBody Reservation reservation) {
        reservation.setReservedDate(Instant.now());
        return reservationService.saveReservation(reservation);
    }

    @RequestMapping("/getbyid/{id}")
    public Reservation fetchReservationById(@PathVariable Integer id) {
        return reservationService.fetchReservationById(id);
    }

    @RequestMapping("/getall")
    public List<Reservation> fetchAllReservations() {
        return reservationService.fetchAllReservations();
    }

    @RequestMapping("/getbybookid/{bookId}")
    public List<Reservation> fetchReservationsByBookId(@PathVariable Integer bookId) {
        return reservationService.fetchReservationsByBookId(bookId);
    }

    @RequestMapping("/getbyuserid/{userId}")
    public List<Reservation> fetchReservationsByUserId(@PathVariable Integer userId) {
        return reservationService.fetchReservationsByUserId(userId);
    }

//    isAvailable,
}
