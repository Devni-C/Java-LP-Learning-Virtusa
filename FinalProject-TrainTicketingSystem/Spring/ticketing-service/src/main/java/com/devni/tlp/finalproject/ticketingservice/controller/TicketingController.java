package com.devni.tlp.finalproject.ticketingservice.controller;

import com.devni.tlp.finalproject.ticketingservice.service.TicketingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticketing")
public class TicketingController {
    @Autowired
    TicketingService ticketingService;
}
