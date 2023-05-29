package com.example.books.controller;

import com.example.books.entity.BookEntity;
import com.example.books.model.BookModel;
import com.example.books.repository.BookRepository;
import com.example.books.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookRepository bookRepository;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody BookModel bookModel){
        return bookService.insert(bookModel);
    }

    @GetMapping("/all")
    public List<BookEntity> all(){
        return bookRepository.findAll();
    }

    @GetMapping("/author/{authorName}")
    public List<BookEntity> authorSpecific(@PathVariable String authorName){

            return bookService.findByAuthor(authorName);

    }

    @GetMapping("/forBook/{bookName}") // returns book name
    public List<BookEntity> bookSpecific(@PathVariable String bookName){
        String decodedBookName = URLDecoder.decode(bookName, StandardCharsets.UTF_8);
        return bookRepository.findByBookName(decodedBookName);
    }
    @GetMapping("/bookName/{bookName}") // returns price
    public Integer priceSpecific(@PathVariable String bookName){
        return bookService.price(bookName);
    }

    @GetMapping("/id/{id}")
    public List<BookEntity> idSpecific(@PathVariable Long id){
        //List <BookEntity> book = bookService.findById(id);

            return bookService.findById(id);

    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){

            bookService.delete(id);
            return "Book has been deleted";
    }

    @PutMapping("/update")
    public String update(@RequestBody BookModel bookModel){

        Long id = bookModel.getId();

            bookService.update(bookModel, id);
            return "Updated successfully";


    }

    @GetMapping("/{authorName}/{bookName}")
    public List<BookEntity> info(@PathVariable String authorName, @PathVariable String bookName){

            return bookService.findByAuthorAndBookName(authorName, bookName);

    }
}
