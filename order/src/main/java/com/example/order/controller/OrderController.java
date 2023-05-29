package com.example.order.controller;

import com.example.order.clients.BookFeignClient;
import com.example.order.clients.PaymentFeignClient;
import com.example.order.model.OrderModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
        if(bookFeignClient.bookSpecific(orderModel.getBookName())==null){
            //return paymentFeignClient.verify(orderModel);
            return "Requested book doesn't exist";
        }
        else{
            //return "Requested book doesn't exist";
            return paymentFeignClient.verify(orderModel);
        }

    }

}
