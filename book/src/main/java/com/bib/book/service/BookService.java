package com.bib.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bib.book.repository.BookRepository;
import com.bib.book.entity.Book;
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    public Book saveBook(Book book) {
        // book.setBrowingId(UUID.randomUUID().toString());
        return bookRepository.save(book);
    }
}
