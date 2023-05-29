package com.example.books.repository;


import com.example.books.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {
    List<BookEntity> findAllById(Long Id);
    //List<BookEntity> findById(Long id);
    List<BookEntity> findAllByAuthor(String authorName);

    List<BookEntity> findByAuthorAndBookName(String author, String bookName);

    //Integer findPriceByBookName(String bookName);
    BookEntity findBookEntityByBookName(String bookName);

    List<BookEntity> findByBookName(String bookName);
    void deleteById(Long id);
}
