package com.enisspahi.example.codefirstapi.service;

import com.enisspahi.example.codefirstapi.model.Book;
import com.enisspahi.example.codefirstapi.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    public Book storeBook(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> bookByIsbn(String isbn) {
        return bookRepository.find(isbn);
    }

}
