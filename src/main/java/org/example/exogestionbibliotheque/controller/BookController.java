package org.example.exogestionbibliotheque.controller;

import org.example.exogestionbibliotheque.entity.Book;
import org.example.exogestionbibliotheque.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public Book createBook() {
        return bookService.createBook();
    }

    @GetMapping("/{id}")
    public Optional<Book> getBook(@PathVariable int id) {
        return bookService.getBook(id);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        return bookService.deleteBook(id);
    }
}
