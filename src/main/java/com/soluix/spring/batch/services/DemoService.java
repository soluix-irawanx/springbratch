package com.soluix.spring.batch.services;

import com.soluix.spring.batch.model.postgres.Product;
import com.soluix.spring.batch.model.mysql.User;
import com.soluix.spring.batch.repository.postgres.ProductRepository;
import com.soluix.spring.batch.repository.mysql.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
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
    public Long createProduct(String name, Double price) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        Product saveProduct = productRepository.save(product);
        return saveProduct.getId();
    }
}
