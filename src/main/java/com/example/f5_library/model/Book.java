
package com.example.f5_library.model;

import jakarta.persistence.*;

@Entity
@Table( name = "books" )
public class Book {

    // ID - Auto Incremental
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;

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

    public Book () {}

    /* GETTERS & SETTERS */

    // ID - Auto Incremental
    public long getId() { return id; }
    public void setId(int id) { this.id = id; }

    // ISBN
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    // TITLE
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    // AUTHOR
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    // GENRE
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    // DESCRIPTION
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}