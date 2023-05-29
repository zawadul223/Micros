package com.microserver.productapp.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class HelloController {

    Logger logger = Logger.getLogger("HelloController");
    @GetMapping("/hello")
    public String hello(){
        logger.info("Hello");
        return "Hello People";
    }
}
