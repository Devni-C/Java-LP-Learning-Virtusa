package com.devni.tlp.finalproject.routeservice.repository;

import com.devni.tlp.finalproject.routeservice.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Trip, Integer> {
}
