package com.devni.tlp.finalproject.routeservice.controller;

import com.devni.tlp.finalproject.routeservice.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/route")
public class RouteController {
    @Autowired
    RouteService routeService;
}
