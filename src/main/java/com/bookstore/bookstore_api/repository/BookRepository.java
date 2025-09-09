package com.bookstore.bookstore_api.repository;

import com.bookstore.bookstore_api.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> 
{
    //No additional methods are needed at this time !!
}
