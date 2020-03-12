package com.devni.tlp.finalproject.reservationservice.service;

import com.devni.tlp.finalproject.reservationservice.model.Lending;

import java.util.List;

public interface LendingService {
    Lending saveLending(Lending lending);

    List<Lending> fetchAllLentBooks();

    Lending fetchLentBookById(int id);
}
