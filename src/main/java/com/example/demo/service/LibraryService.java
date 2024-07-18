package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    private BookRepository bookRepository;

    public void addBook(Book book) {
        if (bookRepository.findByISBN(book.getISBN()) == null) {
            bookRepository.save(book);
        }
    }

    public void removeBook(String ISBN) {
        Book book = bookRepository.findByISBN(ISBN);
        if (book != null) {
            bookRepository.delete(book);
        }
    }

    public List<Book> findBookByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Book> findBookByAuthor(String author) {
        return bookRepository.findByAuthorContainingIgnoreCase(author);
    }

    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> listAvailableBooks() {
        return bookRepository.findAll().stream()
                .filter(Book::isAvailability)
                .toList();
    }
}