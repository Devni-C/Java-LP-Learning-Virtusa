package com.devni.tlp.finalproject.reservationservice.controller;

import com.devni.tlp.finalproject.reservationservice.repository.ReservationRepository;
import com.devni.tlp.finalproject.reservationservice.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {
    @Autowired
    ReservationService reservationService;
}
