package com.devni.tlp.finalproject.bookservice.service;

import com.devni.tlp.finalproject.bookservice.BookServiceApplication;
import com.devni.tlp.finalproject.bookservice.model.Book;
import com.devni.tlp.finalproject.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    /**
     * save new book in the database
     *
     * @param book
     * @return
     */
    @Override
    public Book saveBook(Book book) {
        book.setDeleted(false);
        book.setCreatedAt(Instant.now());
        book.setUpdatedAt(Instant.now());
        return bookRepository.save(book);
    }

    /**
     * update a book in the database
     *
     * @param bookId
     * @return
     */
    @Override
    public Book updateBook(int bookId) {
        Book book = fetchBookById(bookId);
        book.setNoOfCopies(book.getNoOfCopies() - BookServiceApplication.MAX_LENT_BOOKS);
        book.setUpdatedAt(Instant.now());
        return bookRepository.saveAndFlush(book);
    }

    /**
     * deleting/removing a book from the online library
     * the book won't be removed from the db. only the user cannot see them
     *
     * @param bookId
     * @return
     */
    @Override
    public Book removeBook(int bookId) {
        Book book = fetchBookById(bookId);
        book.setDeleted(true);

        return bookRepository.saveAndFlush(book);
    }

    /**
     * update the no of copies of a book after a user returned
     *
     * @param bookId
     * @return
     */
    @Override
    public Book returnBook(int bookId) {
        Book book = fetchBookById(bookId);
        book.setNoOfCopies(book.getNoOfCopies() + BookServiceApplication.MAX_LENT_BOOKS);
        book.setUpdatedAt(Instant.now());
        return bookRepository.saveAndFlush(book);
    }

    /**
     * fetch all books in the database
     *
     * @return
     */
    @Override
    public List<Book> fetchAllBooks() {
        return bookRepository.findAll();
    }

    /**
     * fetching available in the library
     * these are what the user sees
     *
     * @return
     */
    @Override
    public List<Book> fetchAllAvailableBooks() {
        return fetchAllBooks()
                .stream()
                .filter(book -> book.isDeleted() == false)
                .collect(Collectors.toList());
    }

    /**
     * fetching removed/deleted books
     * admin can use these to re-add books
     *
     * @return
     */
    @Override
    public List<Book> fetchAllDeletedBooks() {
        return fetchAllBooks().stream()
                .filter(book -> book.isDeleted() == true)
                .collect(Collectors.toList());
    }

    /**
     * fetch a book by bookID
     *
     * @param id
     * @return
     */
    @Override
    public Book fetchBookById(int id) {
        Optional<Book> optional = bookRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    /*private boolean findByAuthorName(List<String> name) {
        fetchAllBooks().stream()
//                .filter(book -> book.getAuthors().equals(name));
                .filter(book -> book.getAuthors().forEach(author -> {
                    if(name.equals(author))
                        return true;
                }));

        */
}

