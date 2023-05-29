package com.example.books.service;

import com.example.books.entity.BookEntity;
import com.example.books.model.BookModel;
import com.example.books.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImplement implements BookService {

    private final BookRepository bookRepository;

    @Override
    public ResponseEntity<Object> insert(BookModel bookModel){
        System.out.println("enter");
        BookEntity bookEntity = BookEntity.builder()
                .bookName(bookModel.getBookName())
                .author(bookModel.getAuthor())
                .price(bookModel.getPrice())
                .build();
        bookRepository.save(bookEntity);
        System.out.println("end");
        return new ResponseEntity<>("Book entry successful!", HttpStatus.CREATED);
    }

    @Override
    public List<BookEntity> findByAuthor(String authorName){
        return bookRepository.findAllByAuthor(authorName);
    }

    @Override
    public List<BookEntity> findById(Long id){
        return bookRepository.findAllById(id);
    }

    @Override
    public void delete(Long id){
        bookRepository.deleteById(id);
    }

    @Override
    public void update(BookModel bookModel, Long id) {

        //BookEntity bookEntity = bookRepository.findById(id).get();
        Optional<BookEntity> bookEntityOptional = bookRepository.findById(id);

        if (bookEntityOptional.isPresent()) {
            BookEntity bookEntity = bookEntityOptional.get();

            bookEntity.setBookName(bookModel.getBookName());
            bookEntity.setAuthor(bookModel.getAuthor());
            bookEntity.setPrice(bookModel.getPrice());
            bookRepository.save(bookEntity);
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public List<BookEntity> findByAuthorAndBookName(String author, String bookName){
        return bookRepository.findByAuthorAndBookName(author, bookName);
    }

    @Override
    public Integer price(String bookName){
        //return bookRepository.findPriceByBookName(bookName);
        //return  bookRepository.;
        BookEntity bookEntity = bookRepository.findBookEntityByBookName(bookName);
        Integer price = bookEntity.getPrice();
        return price;
    }

}
