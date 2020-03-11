package com.devni.tlp.finalproject.bookservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;

    @ManyToMany(mappedBy = "author")
    List<Book> books;
}
