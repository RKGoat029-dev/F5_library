
package com.example.f5_library.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.f5_library.model.Book;
import com.example.f5_library.service.BookService;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /* CRUD */

    // Create
    @PostMapping("/books")
    public void createBook(@RequestBody Book newBook) {
        bookService.addBook(newBook);
    }

    // Read
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getBooks();
    }

    // Update
    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        try {
            Book updatingBook = bookService.updatedBook(id, updatedBook);
            return new ResponseEntity<>(updatingBook, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete
    @DeleteMapping("/books/{id}")
    public void deleteBookById(@PathVariable int id) {
        bookService.deleteBook(id);
    }


    /* FILTERS */

    // ID
    @GetMapping("/books/id/{id}")
    public ResponseEntity<Book> findBookWithId(@PathVariable int id) {

        Optional<Book> foundBookWithId = bookService.findBookById(id);

        if(foundBookWithId.isPresent()) {
            return new ResponseEntity<>(foundBookWithId.get(), HttpStatus.FOUND);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // ISBN
    @RequestMapping("/books/isbn/{isbn}")
    public ResponseEntity<Book> findBookWithIsbn(@PathVariable String isbn) {

        Optional<Book> foundBookWithIsbn = bookService.findBookByIsbn(isbn);

        if(foundBookWithIsbn.isPresent()) {
            return new ResponseEntity<>(foundBookWithIsbn.get(), HttpStatus.FOUND);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // TITLE
    @RequestMapping("/books/title/{title}")
    public ResponseEntity<Book> findBookWithTitle(@PathVariable String title) {

        Optional<Book> foundBookWithTitle = bookService.findBookByTitle(title);

        if(foundBookWithTitle.isPresent()) {
            return new ResponseEntity<>(foundBookWithTitle.get(), HttpStatus.FOUND);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}



