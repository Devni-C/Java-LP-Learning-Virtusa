package com.devni.tlp.finalproject.userservice.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class User {
    Integer id;
    String name;
    String NIC;
    String mobile;
//    String
}
