package com.soluix.spring.batch.controller;

import com.soluix.spring.batch.model.Product;
import com.soluix.spring.batch.model.User;
import com.soluix.spring.batch.services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class DemoController {

    @Autowired
    DemoService demoService;

    @PostMapping("/users")
    public User createUser(@RequestParam String name, @RequestParam String email) {
        return demoService.createUser(name, email);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestParam String name, @RequestParam Double price) {
        return demoService.createProduct(name, price);
    }
}
