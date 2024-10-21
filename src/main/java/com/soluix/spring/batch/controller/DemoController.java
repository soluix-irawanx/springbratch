package com.soluix.spring.batch.controller;

import com.soluix.spring.batch.model.postgres.Product;
import com.soluix.spring.batch.model.mysql.User;
import com.soluix.spring.batch.services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api")
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

    @GetMapping("/demo")
    public String demo(){
        return "hello Multi dat";
    }
}
