package com.devni.tlp.finalproject.reservationservice.controller;

import com.devni.tlp.finalproject.reservationservice.model.Lending;
import com.devni.tlp.finalproject.reservationservice.service.LendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/lending")
public class LendingController {
    @Autowired
    LendingService lendingService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Lending save(@RequestBody Lending lending) throws Exception {
        lending.setIssuedDate(Instant.now());
        lending.setReturnDate(Instant.now().plus(Duration.ofDays(14)));

        return lendingService.saveLending(lending);
    }

    @RequestMapping("/getall")
    public List<Lending> fetchAllLentBooks() {
        return lendingService.fetchAllLentBooks();
    }

    @RequestMapping("/getbyid/{id}")
    public Lending fetchById(@PathVariable Integer id) {
        return lendingService.fetchLentById(id);
    }

    @RequestMapping("/getbyuserid/{userId}")
    public List<Lending> fetchLentBooksByUserId(@PathVariable Integer userId) {
        return lendingService.fetchLentBooksByUserId(userId);
    }

    @RequestMapping("/getbybookid/{bookId}")
    public Lending fetchLentByBookId(@PathVariable Integer bookId) {
        return lendingService.fetchLentByBookId(bookId);
    }

}

