package com.enisspahi.example.codefirstapi.controller;

import com.enisspahi.example.codefirstapi.model.Book;
import com.enisspahi.example.codefirstapi.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> allBooks() {
        return bookService.allBooks();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book storeBook(@RequestBody Book book) {
        return bookService.storeBook(book);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> bookByIsbn(@PathVariable String isbn) {
        return ResponseEntity.of(bookService.bookByIsbn(isbn));
    }


}
