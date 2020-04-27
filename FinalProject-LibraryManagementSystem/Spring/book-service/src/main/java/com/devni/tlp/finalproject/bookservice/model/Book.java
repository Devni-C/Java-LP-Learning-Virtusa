package com.devni.tlp.finalproject.bookservice.model;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = {@JoinColumn(name = "bookId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authorId", referencedColumnName = "id")}
    )
    @Fetch(FetchMode.SUBSELECT)
    private List<Author> authors;

    /*@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors;// = new HashSet<>();*/

    private String ISBN;
    private int noOfCopies;
    private boolean isDeleted;
    private Instant createdAt;
    private Instant updatedAt;
    private byte[] picByte;
}
