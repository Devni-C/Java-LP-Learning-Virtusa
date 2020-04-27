package com.devni.tlp.finalproject.reservationservice.shared_model;

import lombok.Data;

import java.util.List;

@Data
public class Book {
    private Integer id;
    private String title;
    private List<Author> authors;
    private String ISBN;
    private static int noOfCopies;
//    private int noOfCopies;
    private User user;
    private boolean isDeleted;

    public static int getNoOfCopies() {
        return noOfCopies;
    }

    public static void setNoOfCopies(int noOfCopies) {
        Book.noOfCopies = noOfCopies;
    }
}
