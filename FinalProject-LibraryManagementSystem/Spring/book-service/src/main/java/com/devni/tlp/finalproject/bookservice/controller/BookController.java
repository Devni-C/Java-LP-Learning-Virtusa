package com.devni.tlp.finalproject.bookservice.controller;

import com.devni.tlp.finalproject.bookservice.exception.BookExistException;
import com.devni.tlp.finalproject.bookservice.exception.BookNotFoundException;
import com.devni.tlp.finalproject.bookservice.model.Book;
import com.devni.tlp.finalproject.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {
    private byte[] bytes;

    @Autowired
    BookService bookService;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Book save(@RequestBody Book book) throws BookExistException {
        book.setPicByte(this.bytes);
        return bookService.saveBook(book);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/upload")
    public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
        this.bytes = file.getBytes();
    }

    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    public Book getById(@PathVariable int id) throws BookNotFoundException {
        return bookService.fetchBookById(id);
    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public List<Book> getAll() {
        return bookService.fetchAllBooks();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/update/{id}}", method = RequestMethod.POST)
    public Book updateBook(@PathVariable int id) throws BookNotFoundException {
        return bookService.updateBook(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Book book) throws BookExistException {
        bookService.saveBook(book);
    }

    @RequestMapping(value = "/return/{id}", method = RequestMethod.POST)
    public Book returnBook(@PathVariable int id) throws BookNotFoundException {
        return bookService.returnBook(id);
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.POST)
    public Book deleteBook (@PathVariable int id) throws BookNotFoundException {
        return bookService.removeBook(id);
    }

    @DeleteMapping(path = {"/delete/{id}"})
    public Book deleteById(@PathVariable int id) throws BookNotFoundException {
        return bookService.deleteById(id);
    }

    @RequestMapping(value = "/getavailablebooks", method = RequestMethod.GET)
    public List<Book> getvailableBooks() {
        return bookService.fetchAllAvailableBooks();
    }

    @RequestMapping(value = "/getdeletedbooks", method = RequestMethod.GET)
    public List<Book> getDeletedBooks() {
        return bookService.fetchAllDeletedBooks();
    }
}
