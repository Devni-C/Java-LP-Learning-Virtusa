package com.devni.tlp.finalproject.reservationservice.shared_model;

import lombok.Data;

@Data
public class Book {
    private Integer id;
    private String title;
    //    List<Author> authors;
    private String ISBN;
    private static int noOfCopies;
    private User user;
}
