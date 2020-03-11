package com.devni.tlp.finalproject.bookservice.shared_model;

import lombok.Data;

import java.time.Instant;

@Data
public class Reservation {
    Integer id;
    Integer bookId;
    Instant issuedDate;
    Instant returnDate;
}
