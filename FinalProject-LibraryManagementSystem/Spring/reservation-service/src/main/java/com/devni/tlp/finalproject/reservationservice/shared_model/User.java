package com.devni.tlp.finalproject.reservationservice.shared_model;

import lombok.Data;

@Data
public class User {
    private Integer id;

    private String name;
//    private String NIC;
    private String username;
    private String mobile;
    private boolean isDeleted;
}
