package com.bib.book.contorller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bib.book.repository.BookRepository;
import com.bib.book.service.BookService;
import com.bib.book.entity.Book;
import com.bib.book.exception.ResourceNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

@RequestMapping("/bibli")
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookService bookService;

    // get all books
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // create book
    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    // get book by id
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not exist with id:" + bookId));
        return ResponseEntity.ok(book);
    }

    // update book
    @PutMapping("/books/update")
    public ResponseEntity<Book> updateBook(@RequestBody Book bookDetails) {
        Book book = bookRepository.findById(bookDetails.getBookId())
               .orElseThrow(()-> new ResourceNotFoundException("Book not exist with id:"+bookDetails.getBookId()));
       book.setBookName(bookDetails.getBookName());
       book.setNbExemplaire(bookDetails.getNbExemplaire());
        book.setNbTEmprunt(book.getNbTEmprunt());
        Book updateBook = bookRepository.save(book);
        return ResponseEntity.ok(updateBook);
    }

    // delete book
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteBook(@PathVariable Integer id) {
        Book book = bookRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Book not exit with id:" + id));
        bookRepository.delete(book);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
