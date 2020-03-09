package com.devni.tlp.finalproject.routeservice.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Train {
    private Integer id;
    private String name;
    private int seat;

    enum tClass {
        FIRST_CLASS,
        SECOND_CLASS,
        THIRD_CLASS
    }
}
