package com.devni.tlp.finalproject.reservationservice.repository;

import com.devni.tlp.finalproject.reservationservice.model.Lending;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LendingRepository extends JpaRepository<Lending, Integer> {
}
