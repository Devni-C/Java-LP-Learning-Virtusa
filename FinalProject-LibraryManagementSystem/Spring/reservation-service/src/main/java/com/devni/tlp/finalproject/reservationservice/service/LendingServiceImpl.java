package com.devni.tlp.finalproject.reservationservice.service;

import com.devni.tlp.finalproject.reservationservice.model.Lending;
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
    public Lending saveLending(Lending lending) throws Exception {
        if (getBook(lending.getBookId()).getNoOfCopies() != 0) {
            updateLentBook(lending.getBookId());
            return lendingRepository.save(lending);
        } else {
            throw new Exception("Book is Out of Stock");
        }
    }

    /**
     * update the remaining no of copies of a certain book in the book-service
     *
     * @param bookId
     * @return
     */
    private Book updateLentBook(Integer bookId) {
        Book book = restTemplate.getForObject("http://localhost:8888/book/update/" + bookId, Book.class);
        return book;
    }

    /**
     * fetch book details using book ID from book-service
     *
     * @param bookId
     * @return
     */
    private Book getBook(Integer bookId) {
        Book book = restTemplate.getForObject("http://localhost:8888/book/getbyid/" + bookId, Book.class);
        return book;
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
    public Lending fetchLentByBookId(Integer bookId) {
        Optional<Lending> lent = lendingRepository.findById(bookId);
        if (lent.isPresent()) {
            return lent.get();
        } else
            return null;
    }
}
