package com.devni.tlp.finalproject.bookservice.service;

import com.devni.tlp.finalproject.bookservice.BookServiceApplication;
import com.devni.tlp.finalproject.bookservice.exception.BookExistException;
import com.devni.tlp.finalproject.bookservice.exception.BookNotFoundException;
import com.devni.tlp.finalproject.bookservice.model.Author;
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
    public Book saveBook(Book book) throws BookExistException {
        if (getBookByISBN(book.getISBN())) {
            book.setDeleted(false);
            book.setCreatedAt(Instant.now());
            book.setUpdatedAt(Instant.now());
            return bookRepository.save(book);
        } else {
            throw new BookExistException("This book exists in the db, you can change the no of copies");
        }
    }

    private boolean getBookByISBN(String isbn) {
        List<Book> books = fetchAllBooks().stream()
                .filter(book -> book.getISBN().equals(isbn))
                .collect(Collectors.toList());
        if (books.size() == 0)
            return true;
        return false;
    }

    /**
     * update a book in the database
     *
     * @param bookId
     * @return
     */
    @Override
    public Book updateBook(int bookId) throws BookNotFoundException {
        try {
            Book book = fetchBookById(bookId);
            book.setNoOfCopies(book.getNoOfCopies() - BookServiceApplication.MAX_LENT_BOOKS);
            book.setUpdatedAt(Instant.now());
            return bookRepository.saveAndFlush(book);
        } catch (Exception e) {
            throw new BookNotFoundException("Book is not found", e);
        }
    }

    /**
     * deleting/removing a book from the online library
     * the book won't be removed from the db. only the user cannot see them
     *
     * @param bookId
     * @return
     */
    @Override
    public Book removeBook(int bookId) throws BookNotFoundException {
        Book book = fetchBookById(bookId);
        book.setDeleted(true);

        return bookRepository.saveAndFlush(book);
    }

    @Override
    public Book deleteById(int bookId) throws BookNotFoundException {
        Book book = fetchBookById(bookId);
        bookRepository.delete(book);
        return book;
    }

    /**
     * update the no of copies of a book after a user returned
     *
     * @param bookId
     * @return
     */
    @Override
    public Book returnBook(int bookId) throws BookNotFoundException {
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
    public Book fetchBookById(int id) throws BookNotFoundException {
        try {
            Optional<Book> optional = bookRepository.findById(id);
            if (optional.isPresent()) {
                return optional.get();
            }
            return null;
        } catch (Exception e) {
            throw new BookNotFoundException("Book does not exist, Please & Try again", e);
        }
    }

    private Integer findByAuthorName(String name) {
        List<Book> books = fetchAllBooks();
        System.out.println("1 test Authors: " + books.size());
        for (int i = 0; i < books.size(); i++) {
            System.out.println("2 test Authors:");
            List<Author> authorNames = books.get(i).getAuthors();
            System.out.println("test Authors: " + books.size());
            for (int j = 0; j < authorNames.size(); j++) {
                if (authorNames.get(j).getName().equals(name)) {
                    return authorNames.get(j).getId();
                } else
                    return null;
            }
        }
        return null;
    }
}
