package com.example.order.controller;

import com.example.order.clients.BookFeignClient;
import com.example.order.clients.PaymentFeignClient;
import com.example.order.model.OrderModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    @Autowired
    BookFeignClient bookFeignClient;

    @Autowired
    PaymentFeignClient paymentFeignClient;

    @PostMapping("/place")
    public String placeOrder(@RequestBody OrderModel orderModel){

        try{
            return paymentFeignClient.verify(orderModel);
        }
        catch (Exception e){

            return "Book not found!!";
        }

    }

}
