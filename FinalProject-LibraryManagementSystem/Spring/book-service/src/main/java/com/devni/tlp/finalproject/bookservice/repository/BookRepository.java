package com.devni.tlp.finalproject.bookservice.repository;

import com.devni.tlp.finalproject.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
