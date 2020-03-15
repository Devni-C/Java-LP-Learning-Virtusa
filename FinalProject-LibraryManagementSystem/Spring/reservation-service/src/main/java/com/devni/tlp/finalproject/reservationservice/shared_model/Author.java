package com.devni.tlp.finalproject.reservationservice.shared_model;

import lombok.Data;

import java.util.List;

@Data
public class Author {
    private Integer id;
    private String name;
    private List<Book> books;
}
