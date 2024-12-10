
package com.example.f5_library.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.f5_library.model.Book;
import com.example.f5_library.service.BookService;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) { this.bookService = bookService; }

    /* CRUD */

    // Create
    @PostMapping("/books")
    public void createBook(@RequestBody Book newBook) { bookService.addBook(newBook); }

    // Read
    @GetMapping("/books")
    public List<Book> getAllBooks() { return bookService.getBooks(); }
}
