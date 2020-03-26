package com.devni.tlp.finalproject.bookservice.controller;

import com.devni.tlp.finalproject.bookservice.model.Book;
import com.devni.tlp.finalproject.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Book save(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    public Book getById(@PathVariable int id) {
        return bookService.fetchBookById(id);
    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public List<Book> getAll() {
        return bookService.fetchAllBooks();
    }

    @RequestMapping(value = "/update/{id}}", method = RequestMethod.POST)
    public Book updateBook(@PathVariable int id) {
        return bookService.updateBook(id);
    }

    @RequestMapping(value = "/return/{id}", method = RequestMethod.POST)
    public Book returnBook(@PathVariable int id) {
        return bookService.returnBook(id);
    }
}
