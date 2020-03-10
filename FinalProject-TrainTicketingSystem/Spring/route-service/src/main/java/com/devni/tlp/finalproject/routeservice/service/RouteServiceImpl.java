package com.devni.tlp.finalproject.routeservice.service;

import com.devni.tlp.finalproject.routeservice.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/route")
public class RouteServiceImpl implements RouteService {
    @Autowired
    RouteRepository routeRepository;
}
