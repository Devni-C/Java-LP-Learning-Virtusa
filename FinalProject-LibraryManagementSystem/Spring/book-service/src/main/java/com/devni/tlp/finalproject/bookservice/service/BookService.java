package com.devni.tlp.finalproject.bookservice.service;

import com.devni.tlp.finalproject.bookservice.exception.BookExistException;
import com.devni.tlp.finalproject.bookservice.exception.BookNotFoundException;
import com.devni.tlp.finalproject.bookservice.model.Book;

import java.util.List;

public interface BookService {
    Book saveBook(Book book) throws BookExistException;

    Book updateBook(int bookId) throws BookNotFoundException;

    Book removeBook(int bookId) throws BookNotFoundException;

    Book deleteById(int bookId) throws BookNotFoundException;

    Book returnBook(int bookId) throws BookNotFoundException;

    List<Book> fetchAllBooks();

    List<Book> fetchAllAvailableBooks();

    List<Book> fetchAllDeletedBooks();

    Book fetchBookById(int id) throws BookNotFoundException;

    //fetch reserved books by user id
    //List<Book> fetchByUserId(int uid);

//    List<Book> fetchBookByAuthorId  ==== is this necessary????
}
