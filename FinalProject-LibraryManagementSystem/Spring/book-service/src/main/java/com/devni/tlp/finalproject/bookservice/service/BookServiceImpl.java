package com.devni.tlp.finalproject.bookservice.service;

import com.devni.tlp.finalproject.bookservice.BookServiceApplication;
import com.devni.tlp.finalproject.bookservice.model.Book;
import com.devni.tlp.finalproject.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

