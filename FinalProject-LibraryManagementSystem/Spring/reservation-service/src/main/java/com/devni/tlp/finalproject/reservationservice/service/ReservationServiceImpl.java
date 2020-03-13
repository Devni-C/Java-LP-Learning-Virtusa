package com.devni.tlp.finalproject.reservationservice.service;

import com.devni.tlp.finalproject.reservationservice.model.Lending;
import com.devni.tlp.finalproject.reservationservice.model.Reservation;
import com.devni.tlp.finalproject.reservationservice.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    /**
     * save new book reservation
     *
     * @param reservation
     * @return
     */
    @Override
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    /**
     * fetch reservation by reservation id
     *
     * @param id
     * @return
     */
    @Override
    public Reservation fetchReservationById(Integer id) {
        Optional<Reservation> optional = reservationRepository.findById(id);
        if (optional.isPresent()) {
            System.out.println("test get by id");
            return optional.get();
        }
        return null;
    }

    /**
     * fetch all reservations
     *
     * @return
     */
    @Override
    public List<Reservation> fetchAllReservations() {
        return reservationRepository.findAll();
    }

    /**
     * fetch reservations by book id
     *
     * @param bookId
     * @return
     */
    @Override
    public List<Reservation> fetchReservationsByBookId(Integer bookId) {
        return null;
    }

    /**
     * fetch reservations by user id
     *
     * @param userId
     * @return
     */
    @Override
    public List<Reservation> fetchReservationsByUserId(Integer userId) {
        return reservationRepository.findAll().stream()
                .filter(reservation -> reservation.getUserId() == userId)
                .collect(Collectors.toList());
    }



/**
 * fetch reserved book by userID
 *
 * @param uid
 * @return
 */
    /*@Override
    public List<Reservation> getReservationsByBookId(Integer uid) {
        return reservationRepository.findAll().stream()
                .filter(reservation -> reservation.getUser().getId() == uid)
                .collect(Collectors.toList());
    }*/

//    @Override
//    public List<Reservation> getReservationsByBookId(int id) {
//        return reservationRepository.get
//    }
}
