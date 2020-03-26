package com.devni.tlp.finalproject.bookservice.service;

import com.devni.tlp.finalproject.bookservice.model.Book;

import java.util.List;

public interface BookService {
    Book saveBook(Book book);

    Book updateBook(int bookId);

    Book returnBook(int bookId);

    List<Book> fetchAllBooks();

    Book fetchBookById(int id);

    //fetch reserved books by user id
    //List<Book> fetchByUserId(int uid);

//    List<Book> fetchBookByAuthorId  ==== is this necessary????
}
