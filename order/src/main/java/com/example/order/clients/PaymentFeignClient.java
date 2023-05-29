package com.example.order.clients;

import com.example.order.model.OrderModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PAYMENT-APP")
public interface PaymentFeignClient {
    @PostMapping("/Payment/verify")
    String verify(@RequestBody OrderModel orderModel);
}
