package com.devni.tlp.finalproject.bookservice.service;

import com.devni.tlp.finalproject.bookservice.model.Book;
import com.devni.tlp.finalproject.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    /**
     * save new book in the database
     * @param book
     * @return
     */
    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    /**
     * update a book in the database
     * @param id
     * @return
     */
    public Book updateBook(int id, int copies) {
//        return fetchBookById(id).setNoOfCopies(copies);
        return null;
    }

    /**
     * fetch all books in the database
     * @return
     */
    @Override
    public List<Book> fetchAllBooks() {
        return bookRepository.findAll();
    }

    /**
     * fetch a book by bookID
     * @param id
     * @return
     */
    @Override
    public Book fetchBookById(int id) {
        Optional<Book> optional = bookRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

   /* *//**
     * fetch reserved books by user ID
     * @param //uid
     * @return
     *//*
    @Override
    public List<Book> fetchByUserId(int uid) {
        return fetchAllBooks().stream()
                .filter(book -> book.getUser().getId() == uid)
                .collect(Collectors.toList());
    }*/

    //fetch reserved books by author id
    public List<Book> fetchByAuthorId(int id) {
//        fetchAllBooks().stream()
//                .filter(book -> book.getAuthors().get());
        return null;
    }



 /*   public List<Book> fetchByAuthorId(int id) {
        Reservation reservation = new Reservation();
//        reservation.
//        return bookRepository.findAll(Example.of())
    }*/
}
