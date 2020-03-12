package com.devni.tlp.finalproject.reservationservice.shared_model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.ManyToMany;
import java.util.List;

@Data
public class Author {
    Integer id;
    String name;
    List<Book> books;
}
