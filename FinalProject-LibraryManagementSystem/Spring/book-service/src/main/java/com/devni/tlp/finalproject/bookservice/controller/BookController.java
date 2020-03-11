package com.devni.tlp.finalproject.bookservice.controller;

import com.devni.tlp.finalproject.bookservice.model.Book;
import com.devni.tlp.finalproject.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping("/save")
    public Book save(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @RequestMapping("/getbyid/{id}")
    public Book getById(@PathVariable int id) {
        return bookService.fetchBookById(id);
    }

    @RequestMapping("/getall")
    public List<Book> getAll() {
        return bookService.fetchAllBooks();
    }
}
