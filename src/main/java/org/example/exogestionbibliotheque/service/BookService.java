package org.example.exogestionbibliotheque.service;

import org.example.exogestionbibliotheque.annotation.AnnotationLog;
import org.example.exogestionbibliotheque.annotation.AnnotationPerformance;
import org.example.exogestionbibliotheque.entity.Book;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class BookService {
    private List<Book> books = new ArrayList<>();
    private int currentId = 1;

    public BookService() {
        books.add(new Book(currentId++, "Le dernier message", "Nicolas Beuglet"));
        books.add(new Book(currentId++, "La Vallée", "Bernard Minier"));
        books.add(new Book(currentId++, "Level 26", "zuiker"));

    }

    @AnnotationPerformance
    public Book createBook() {
        Book book = new Book();
        books.add(book);
        return book;

    }

    @AnnotationLog
    public Optional<Book> getBook(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst();
    }

    @AnnotationPerformance
    public String deleteBook(int id) {
        Optional<Book> bookToRemove = getBook(id);
        if (bookToRemove.isPresent()) {
            books.remove(bookToRemove.get());
            return "Livre supprimé";
        } else {
            return "Livre non trouvé";
        }
    }

}
