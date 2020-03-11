package com.devni.tlp.finalproject.bookservice.controller;

import com.devni.tlp.finalproject.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
}
