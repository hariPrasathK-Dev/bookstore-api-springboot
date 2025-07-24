package com.bookstore.bookstore_api.repository;

import com.bookstore.bookstore_api.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
