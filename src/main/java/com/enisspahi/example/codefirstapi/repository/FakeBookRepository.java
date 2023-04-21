package com.enisspahi.example.codefirstapi.repository;

import com.enisspahi.example.codefirstapi.model.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
class FakeBookRepository implements BookRepository {

    private final List<Book> books = new ArrayList();

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public Book save(Book book) {
        books.add(book);
        return book;
    }

    @Override
    public Optional<Book> find(String isbn) {
        return books.stream()
                .filter(book -> book.isbn().equals(isbn))
                .findFirst();
    }
}
