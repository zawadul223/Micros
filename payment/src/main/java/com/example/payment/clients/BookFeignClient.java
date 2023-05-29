package com.example.payment.clients;


import com.example.books.entity.BookEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "BOOKS")
public interface BookFeignClient {
    @GetMapping("/book/bookName/{bookName}")
    Integer priceSpecific(@PathVariable("bookName") String bookName);
}
