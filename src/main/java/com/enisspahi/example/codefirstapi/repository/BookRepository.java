package com.enisspahi.example.codefirstapi.repository;

import com.enisspahi.example.codefirstapi.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> findAll();

    Book save(Book book);

    Optional<Book> find(String isbn);
}
