package com.devni.tlp.finalproject.bookservice.model;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = {@JoinColumn(name = "bookId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authorId", referencedColumnName = "id")}
    )
    @Fetch(FetchMode.SUBSELECT)
    private List<Author> authors;

    private String ISBN;
    private int noOfCopies;
}
