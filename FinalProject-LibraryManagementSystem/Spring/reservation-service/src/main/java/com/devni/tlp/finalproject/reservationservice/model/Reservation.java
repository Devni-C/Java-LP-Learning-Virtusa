package com.devni.tlp.finalproject.reservationservice.model;

import com.devni.tlp.finalproject.reservationservice.shared_model.Book;
import com.devni.tlp.finalproject.reservationservice.shared_model.User;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Instant reservedDate;

    private Integer bookId;
    private Integer userId;

    @Transient
    private Book[] books;

    @Transient
    private User[] users;
}
