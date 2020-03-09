package com.devni.tlp.finalproject.routeservice.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Station {
    private Integer id;
    private String name;
    private String location;
    private String telephone;
}
