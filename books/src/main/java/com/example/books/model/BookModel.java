package com.example.books.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookModel {
    private String bookName;
    private String author;
    private Long id;
    private Integer price;
}
