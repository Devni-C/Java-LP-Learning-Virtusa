package com.devni.tlp.finalproject.routeservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Entity
@Data
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private static int seat;
    private Instant startTime;
    private Instant endTime;
    private Station startStation;
    private Station endStation;

    enum tClass {
        FIRST_CLASS,
        SECOND_CLASS,
        THIRD_CLASS
    }
}
