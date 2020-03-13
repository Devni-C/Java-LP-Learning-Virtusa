package com.devni.tlp.finalproject.reservationservice.service;

import com.devni.tlp.finalproject.reservationservice.model.Lending;
import com.devni.tlp.finalproject.reservationservice.repository.LendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Service
public class LendingServiceImpl implements LendingService {
    @Autowired
    LendingRepository lendingRepository;

    /**
     * save a lent book
     * @param lending
     * @return
     */
    @Override
    public Lending saveLending(Lending lending) {
        return lendingRepository.save(lending);
    }

    @Override
    public List<Lending> fetchAllLentBooks() {
        return lendingRepository.findAll();
    }

    @Override
    public List<Lending> fetchLentBooksByUserId(Integer userId) {
        Lending lending = new Lending();
        lending.setUserId(userId);
        Example<Lending> example = Example.of(lending);

        return lendingRepository.findAll(example);
    }


    /**
     * fetch a lent book by bookID
     * @param bookId
     * @return
     *//*
    @Override
    public Lending fetchLentByBookId(int bookId) {
        return null;
    }*/

}
