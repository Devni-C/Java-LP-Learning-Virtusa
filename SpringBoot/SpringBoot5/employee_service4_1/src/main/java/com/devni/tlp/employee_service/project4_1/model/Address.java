package com.devni.tlp.employee_service.project4_1.model;

import lombok.Data;

import javax.persistence.*;

@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String city;
}
