package com.devni.tlp.finalproject.reservationservice.controller;

import com.devni.tlp.finalproject.reservationservice.model.Lending;
import com.devni.tlp.finalproject.reservationservice.service.LendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@RestController("/lending")
public class LendingController {
    @Autowired
    LendingService lendingService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Lending save(@RequestBody Lending lending) {
        lending.setIssuedDate(Instant.now());
        lending.setReturnDate(Instant.now().plus(Duration.ofDays(14)));
        return lendingService.saveLending(lending);
    }

    @RequestMapping("/getall")
    public List<Lending> fetchAllLentBooks() {
        return lendingService.fetchAllLentBooks();
    }

    @RequestMapping("/getbyuserid")
    public List<Lending> fetchLentBooksByUserId(@PathVariable Integer userId) {
        return lendingService.fetchLentBooksByUserId(userId);
    }

//    @RequestMapping("/getbybookid/{userId}")
//    Lending fetchLentByBookId(int bookId);

}

