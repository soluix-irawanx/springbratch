//package com.soluix.spring.batch.processor;
//
//import com.soluix.spring.batch.model.mysql.User;
//import com.soluix.spring.batch.model.postgres.Product;
//import org.springframework.batch.item.ItemProcessor;
//
//public class UserItemProcessor implements ItemProcessor<User, Product> {
//
//    @Override
//    public Product process(User user) throws Exception {
//        Product transformedProduct = new Product();
//        transformedProduct.setName(user.getName());
//        transformedProduct.setPrice(200.00);
//        return transformedProduct;
//    }
//}
