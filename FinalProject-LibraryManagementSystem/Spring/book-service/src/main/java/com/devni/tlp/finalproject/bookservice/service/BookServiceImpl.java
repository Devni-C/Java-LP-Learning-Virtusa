package com.devni.tlp.finalproject.bookservice.service;

import com.devni.tlp.finalproject.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/book")
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;
}
