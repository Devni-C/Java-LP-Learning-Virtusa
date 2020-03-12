package com.devni.tlp.finalproject.reservationservice.controller;

import com.devni.tlp.finalproject.reservationservice.model.Lending;
import com.devni.tlp.finalproject.reservationservice.service.LendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/lending")
public class LendingController {
    @Autowired
    LendingService lendingService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Lending save(@RequestBody Lending lending) {
        return lendingService.saveLending(lending);
    }


}
