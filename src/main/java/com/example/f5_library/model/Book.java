
package com.example.f5_library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@NoArgsConstructor @Getter @Setter
public class Book {

    // ID - Auto Incremental
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    // ISBN
    private String isbn;

    // TITLE
    private String title;

    // AUTHOr
    private String author;

    // GENRE
    private String genre;

    // DESCRIPTION
    private String description;

    /* CONSTRUCTORS */

    public Book (
            String isbn,
            String title,
            String author,
            String genre,
            String description
    ) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.description = description;
    }

}