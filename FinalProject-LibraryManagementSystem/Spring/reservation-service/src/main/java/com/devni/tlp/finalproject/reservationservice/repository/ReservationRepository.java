package com.devni.tlp.finalproject.reservationservice.repository;

import com.devni.tlp.finalproject.reservationservice.model.ReserveInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<ReserveInfo, Integer> {
}
