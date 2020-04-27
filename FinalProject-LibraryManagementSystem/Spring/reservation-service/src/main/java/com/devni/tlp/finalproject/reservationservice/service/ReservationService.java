package com.devni.tlp.finalproject.reservationservice.service;

import com.devni.tlp.finalproject.reservationservice.model.Reservation;
import com.devni.tlp.finalproject.reservationservice.shared_model.Book;
import com.devni.tlp.finalproject.reservationservice.shared_model.User;

import java.util.List;

public interface ReservationService {
    Reservation saveReservation(Reservation reservation) throws Exception;

    Reservation deleteReservation(int id);

    Reservation fetchReservationById(Integer id);

    List<Reservation> fetchAllReservations();

    List<Reservation> fetchReservationsByBookId(Integer bookId);

    List<Reservation> fetchReservationsByUserId(Integer userId);

    Book getBook(int bookId);

    User getUser(int userId);

}
