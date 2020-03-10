package com.devni.tlp.finalproject.routeservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Entity
@Data
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Instant startTime;
    Instant endTime;
    Station startStation;
    Station endStation;
    Train train;

}
