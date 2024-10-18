package com.soluix.spring.batch.services;

import com.soluix.spring.batch.model.Product;
import com.soluix.spring.batch.model.User;
import com.soluix.spring.batch.repository.ProductRepository;
import com.soluix.spring.batch.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class DemoService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Transactional("mysqlTransactionManager")
    public User createUser(String name, String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        return userRepository.save(user);
    }

    @Transactional("postgresTransactionManager")
    public Product createProduct(String name, Double price) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        return productRepository.save(product);
    }
}
