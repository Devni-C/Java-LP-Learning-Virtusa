package com.devni.tlp.finalproject.reservationservice.shared_model;

import lombok.Data;

import java.util.List;

@Data
public class Book {
    Integer id;
    String title;
//    List<Author> authors;
    String ISBN;
    int noOfCopies;
    User user;
}
