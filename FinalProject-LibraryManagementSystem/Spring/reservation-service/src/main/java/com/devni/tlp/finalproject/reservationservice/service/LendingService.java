package com.devni.tlp.finalproject.reservationservice.service;

import com.devni.tlp.finalproject.reservationservice.exception.BookNotFoundException;
import com.devni.tlp.finalproject.reservationservice.model.Lending;

import java.util.List;

public interface LendingService {
    Lending saveLending(Lending lending) throws Exception;

    Lending fetchLentById(Integer id);

    List<Lending> fetchAllLentBooks();

    List<Lending> fetchLentBooksByUserId(Integer userId);

    Lending fetchLentByBookId(Integer bookId) throws BookNotFoundException;

}
