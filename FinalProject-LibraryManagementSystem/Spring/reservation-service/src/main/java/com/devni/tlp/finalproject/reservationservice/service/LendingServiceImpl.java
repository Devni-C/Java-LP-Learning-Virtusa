package com.devni.tlp.finalproject.reservationservice.service;

import com.devni.tlp.finalproject.reservationservice.model.Lending;
import com.devni.tlp.finalproject.reservationservice.repository.LendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * fetch all lent books
     * @return
     */
    @Override
    public List<Lending> fetchAllLentBooks() {
        return lendingRepository.findAll();
    }

    /**
     * fetch a lent book by bookID
     * @param id
     * @return
     */
    @Override
    public Lending fetchLentBookById(int id) {
        return lendingRepository.findById(id).get();
    }

}
