package com.example.books.service;

import com.example.books.entity.BookEntity;
import com.example.books.model.BookModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {
    ResponseEntity<Object> insert(BookModel bookModel);
    List<BookEntity> findByAuthor(String authorName);

    List<BookEntity> findById(Long id);

    void delete(Long id);

    void update(BookModel bookModel, Long id);

    List<BookEntity> findByAuthorAndBookName(String author, String bookName);

    Integer price(String bookName);
}
