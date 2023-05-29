package com.example.payment.controller;

import com.example.payment.clients.BookFeignClient;
import com.example.payment.model.OrderModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Payment")
@RequiredArgsConstructor
public class PaymentController {

    @Autowired
    BookFeignClient bookFeignClient;

    @PostMapping("/verify")
    public String verify(@RequestBody OrderModel orderModel){
        Integer price = bookFeignClient.priceSpecific(orderModel.getBookName());
        Integer paid = orderModel.getPayment();
        if(paid.equals(price)){
            return "Your order has been placed";
        } else if (paid > price) {
            Integer change = paid - price;
            return "Your order has been placed. Change amount: "+ change;
        }
        else{
            return "Not sufficient amount";
        }
    }
}
