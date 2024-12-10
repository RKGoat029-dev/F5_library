
package com.example.f5_library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.f5_library.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {}
