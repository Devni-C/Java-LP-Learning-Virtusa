package com.devni.tlp.finalproject.reservationservice.service;

import com.devni.tlp.finalproject.reservationservice.exception.BookNotFoundException;
import com.devni.tlp.finalproject.reservationservice.exception.LendingNotSavedException;
import com.devni.tlp.finalproject.reservationservice.model.Lending;
import com.devni.tlp.finalproject.reservationservice.model.Reservation;
import com.devni.tlp.finalproject.reservationservice.repository.LendingRepository;
import com.devni.tlp.finalproject.reservationservice.shared_model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

import static com.devni.tlp.finalproject.reservationservice.ReservationServiceApplication.BOOK_URL;
import static com.devni.tlp.finalproject.reservationservice.ReservationServiceApplication.MAX_BOOKS_TO_LEND;

@Service
public class LendingServiceImpl implements LendingService {
    @Autowired
    LendingRepository lendingRepository;

    @Bean
    RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Autowired
    RestTemplate restTemplate;

    /**
     * save a lent book
     *
     * @param lending
     * @return
     */
    @Override
    public Lending saveLending(Lending lending) throws LendingNotSavedException {
        if (fetchLentBooksByUserId(lending.getUserId()).size() <= MAX_BOOKS_TO_LEND) {
            if (getBook(lending.getBookId()).getNoOfCopies() != 0) { // copies available
                if (getReservations(lending.getBookId()).size() == 0) { // no reservations -> you can get the book
                    updateLentBook(lending.getBookId());
                    return lendingRepository.save(lending);

                } else if (getReservations(lending.getBookId()).contains(lending.getUserId())) { //available reservations
                    if (getReservations(lending.getBookId()).get(0).getUserId() == lending.getUserId()) {
                        //here you have to check the logged user's id
                        updateLentBook(lending.getBookId());
                        return lendingRepository.save(lending);

                    } else {
                        throw new LendingNotSavedException("1 You have to wait in the reservation list to borrow this book");
                    }
                } else {
                    throw new LendingNotSavedException("2 Book is not available. You can reserve this book");
                }
            } else {
                throw new LendingNotSavedException("3 Book is not available. You can reserve this book");
            }
        } else {
            throw new LendingNotSavedException("4 Sorry..You can't lend more than 2 books");
        }
    }

    /**
     * update the remaining no of copies of a certain book in the book-service
     *
     * @param bookId
     * @return
     */
    private Book updateLentBook(Integer bookId) {
        Book book = restTemplate.getForObject(BOOK_URL + "update/" + bookId, Book.class);
        return book;
    }

    /**
     * fetch book details using book ID from book-service
     *
     * @param bookId
     * @return
     */
    private Book getBook(Integer bookId) {
        Book book = restTemplate.getForObject(BOOK_URL + "getbyid/" + bookId, Book.class);
        return book;
    }

    private List<Reservation> getReservations(Integer bookId) {
//        ReservationService reservationService = new ReservationServiceImpl();
//        return reservationService.fetchReservationsByBookId(bookId);
        List<Reservation> reservations = (List<Reservation>) restTemplate.getForObject("http://localhost:9191/reserve/getbybookid/" + bookId, Reservation.class);
        System.out.println("getReservations = " + reservations.size());
        return reservations;
    }

    /**
     * fetch lent book by lent ID
     *
     * @param id
     * @return
     */
    @Override
    public Lending fetchLentById(Integer id) {
        Optional<Lending> lending = lendingRepository.findById(id);
        if (lending.isPresent()) {
            return lending.get();
        }
        return null;
    }

    /**
     * fetch all lent books
     *
     * @return
     */
    @Override
    public List<Lending> fetchAllLentBooks() {
        return lendingRepository.findAll();
    }

    /**
     * fetch all lent books by user ID
     *
     * @param userId
     * @return
     */
    @Override
    public List<Lending> fetchLentBooksByUserId(Integer userId) {
        Lending lending = new Lending();
        lending.setUserId(userId);
        Example<Lending> example = Example.of(lending);

        return lendingRepository.findAll(example);
    }

    /**
     * fetch all lent books by Book ID
     * (there can be more than one copy of a certain book
     * so there will be more than one lent IDs related to one book ID )
     *
     * @param bookId
     * @return
     */
    @Override
    public Lending fetchLentByBookId(Integer bookId) throws BookNotFoundException {
        Optional<Lending> lent = lendingRepository.findById(bookId);
        if (lent.isPresent()) {
            return lent.get();
        } else {
//            return null;
            throw new BookNotFoundException("Book not found");
        }
    }
}
