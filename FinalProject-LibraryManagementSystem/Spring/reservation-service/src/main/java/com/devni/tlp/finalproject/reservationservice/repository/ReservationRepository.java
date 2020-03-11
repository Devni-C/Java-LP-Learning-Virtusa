package com.devni.tlp.finalproject.reservationservice.repository;

import com.devni.tlp.finalproject.reservationservice.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
