
package com.example.f5_library.service;

import java.util.List;
import com.example.f5_library.model.Book;
import com.example.f5_library.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) { this.bookRepository = bookRepository; }

    /* CRUD */

    // Create
    public Book addBook(Book newBook) { return bookRepository.save(newBook); }

    // Read
    public List<Book> getBooks() { return bookRepository.findAll(); }
}
