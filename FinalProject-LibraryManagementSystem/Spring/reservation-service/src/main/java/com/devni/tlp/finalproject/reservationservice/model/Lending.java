package com.devni.tlp.finalproject.reservationservice.model;

import com.devni.tlp.finalproject.reservationservice.shared_model.Book;
import com.devni.tlp.finalproject.reservationservice.shared_model.User;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
public class Lending {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Instant issuedDate;
    Instant returnDate;


    @Transient
    Book book;

    @Transient
    User user;
//    duration dates
}
