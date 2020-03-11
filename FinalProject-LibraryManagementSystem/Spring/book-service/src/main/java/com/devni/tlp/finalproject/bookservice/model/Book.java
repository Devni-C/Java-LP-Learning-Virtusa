package com.devni.tlp.finalproject.bookservice.model;

import com.devni.tlp.finalproject.bookservice.shared_model.Reservation;
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
    Integer id;
    String title;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = {@JoinColumn(name = "bookId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authorId", referencedColumnName = "id")}
    )
    @Fetch(FetchMode.SUBSELECT)
    List<Author> authors;

    @Transient
    Reservation[] reservations;

    String ISBN;
    int noOfCopies;
}
