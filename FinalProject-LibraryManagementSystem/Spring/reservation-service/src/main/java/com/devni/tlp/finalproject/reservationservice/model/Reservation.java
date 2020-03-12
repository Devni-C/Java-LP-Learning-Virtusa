package com.devni.tlp.finalproject.reservationservice.model;

import com.devni.tlp.finalproject.reservationservice.shared_model.Book;
import com.devni.tlp.finalproject.reservationservice.shared_model.User;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

//    Instant reservedDate;
    Date reservedDate;

    @Transient
    Book book;

    @Transient
    User user;
//    duration dates

}
