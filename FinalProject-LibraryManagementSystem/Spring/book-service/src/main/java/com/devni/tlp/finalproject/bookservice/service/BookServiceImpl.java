package com.devni.tlp.finalproject.bookservice.service;

import com.devni.tlp.finalproject.bookservice.model.Book;
import com.devni.tlp.finalproject.bookservice.repository.BookRepository;
import com.devni.tlp.finalproject.bookservice.shared_model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> fetchAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book fetchBookById(int id) {
        Optional<Book> optional = bookRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    //fetch reserved books by user id
    public List<Book> fetchByUserId(int id) {
//        Optional<Book> optional = bookRepository.findAllById()
        return null;
    }
 /*   public List<Book> fetchByAuthorId(int id) {
        Reservation reservation = new Reservation();
//        reservation.
//        return bookRepository.findAll(Example.of())
    }*/
}
