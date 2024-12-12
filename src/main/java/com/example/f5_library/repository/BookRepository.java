
package com.example.f5_library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.f5_library.model.Book;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findByIsbn(String isbn);
    Optional<Book> findByTitle(String title);
}
