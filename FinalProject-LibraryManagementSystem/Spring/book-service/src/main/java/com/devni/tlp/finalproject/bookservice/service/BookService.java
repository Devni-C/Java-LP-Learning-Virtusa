package com.devni.tlp.finalproject.bookservice.service;

import com.devni.tlp.finalproject.bookservice.model.Book;

import java.util.List;

public interface BookService {
    Book saveBook(Book book);

    List<Book> fetchAllBooks();

    Book fetchBookById(int id);

//    List<Book> fetchBookAuthorId  ==== is this necessary????
}
