
package com.example.f5_library.service;

import java.util.List;
import java.util.Optional;
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

    // Update
    public Book updatedBook(int id, Book updatedBook) {

        Optional<Book> foundBook = bookRepository.findById(id);

        if (foundBook.isPresent()) {
            Book resultBook = foundBook.get();

            resultBook.setIsbn(updatedBook.getIsbn());
            resultBook.setTitle(updatedBook.getTitle());
            resultBook.setAuthor(updatedBook.getAuthor());
            resultBook.setGenre(updatedBook.getGenre());
            resultBook.setDescription(updatedBook.getDescription());

            return bookRepository.save(resultBook);
        }

        throw new RuntimeException("Not found.");
    }

    // Delete
    public void deleteBook(int id) {bookRepository.deleteById(id); }


    /* FILTERS */

    // ID
    public Optional<Book> findBookById(int id) { return bookRepository.findById(id); }

    // ISBN
    public Optional<Book> findBookByIsbn(String isbn) { return bookRepository.findByIsbn(isbn); }

    // TITLE
    public Optional<Book> findBookByTitle(String title) { return bookRepository.findByTitle(title);}
}