package com.devni.tlp.finalproject.ticketingservice.service;

import com.devni.tlp.finalproject.ticketingservice.repository.TicketingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketingServiceImpl implements TicketingService {
    @Autowired
    TicketingRepository ticketingRepository;
}
