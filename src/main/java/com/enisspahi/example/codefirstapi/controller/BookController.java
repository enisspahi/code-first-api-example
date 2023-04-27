package com.enisspahi.example.codefirstapi.controller;

import com.enisspahi.example.codefirstapi.model.Book;
import com.enisspahi.example.codefirstapi.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "https://enisspahi.github.io")
@Tag(name = "Books API")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    @Operation(summary = "Show all books")
    public List<Book> findAllBooks() {
        return bookService.allBooks();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a book")
    public Book createBook(@RequestBody Book book) {
        return bookService.storeBook(book);
    }

    @GetMapping("/{isbn}")
    @Operation(summary = "Find book by isbn")
    public Book findBookByIsbn(@PathVariable String isbn) {
        return bookService.bookByIsbn(isbn).orElseThrow(BookNotFound::new);
    }

}
