package com.bib.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bib.book.entity.Book;



public interface BookRepository extends JpaRepository<Book,Integer> {
}
