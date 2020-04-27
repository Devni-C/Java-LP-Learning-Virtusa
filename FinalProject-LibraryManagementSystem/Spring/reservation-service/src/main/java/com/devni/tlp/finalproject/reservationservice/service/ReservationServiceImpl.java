package com.devni.tlp.finalproject.reservationservice.service;

import com.devni.tlp.finalproject.reservationservice.ReservationServiceApplication;
import com.devni.tlp.finalproject.reservationservice.model.Reservation;
import com.devni.tlp.finalproject.reservationservice.repository.ReservationRepository;
import com.devni.tlp.finalproject.reservationservice.shared_model.Book;
import com.devni.tlp.finalproject.reservationservice.shared_model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

//    @Bean
//    RestTemplate getRestTemplate(RestTemplateBuilder builder) {
//        return builder.build();
//    }

    @Autowired
    RestTemplate restTemplate;

    /**
     * save new book reservation
     *
     * @param reservation
     * @return
     */
    @Override
    public Reservation saveReservation(Reservation reservation) throws Exception {
        if (fetchReservationsByUserId(reservation.getUserId()).size() <= ReservationServiceApplication.MAX_BOOKS_TO_RESERVE) {
            return reservationRepository.save(reservation);
        } else {
            throw new Exception("You can't reserve more than 5 books");
        }
    }

    @Override
    public Reservation deleteReservation(int id) {
        Reservation reservation = fetchReservationById(id);
        reservationRepository.delete(reservation);
        return reservation;
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
//    public Reservation fetchReservationsByBookId(Integer bookId) {
//        Optional<Reservation> reservation = reservationRepository.findById(bookId);

//        List<Reservation> reservations = restTemplate.getForObject();

        return reservationRepository.findAll().stream()
                .filter(reservation -> reservation.getBookId() == bookId)
                .collect(Collectors.toList());
    }

    @Override
    public Book getBook(int bookId) {
        Book book = restTemplate.getForObject("http://localhost:8888/book/getbyid/" + bookId, Book.class);
        return book;
    }

    @Override
    public User getUser(int userId) {
        User user = restTemplate.getForObject("http://localhost:7788//api/test/getuserbyid/" + userId, User.class);
        return user;
    }

    /*private Author getAuthor(int authorId) {
        Author author = restTemplate.getForObject("http://" + authorId, Author.class);
        return author;
    }*/

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
}
