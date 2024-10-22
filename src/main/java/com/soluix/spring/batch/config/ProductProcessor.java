//package com.soluix.spring.batch.config;
//
//import com.soluix.spring.batch.model.mysql.User;
//import com.soluix.spring.batch.model.postgres.Product;
//import lombok.RequiredArgsConstructor;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class ProductProcessor implements ItemProcessor<User, Product> {
//
//    @Override
//    public Product process(User user) throws Exception {
//        return mapProduct(user);
//    }
//
//    private Product mapProduct(User user){
//        Product product = new Product();
//        product.setName(user.getName() + "008");
//        product.setPrice(20.00);
//        return product;
//    }
//
//
//}
