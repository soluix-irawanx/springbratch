//package com.soluix.spring.batch.config;
//
//import com.soluix.spring.batch.model.mysql.User;
//import com.soluix.spring.batch.model.postgres.Product;
//import com.soluix.spring.batch.repository.mysql.UserRepository;
//import com.soluix.spring.batch.repository.postgres.ProductRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.batch.item.Chunk;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.beans.factory.annotation.Autowired;
//
//@RequiredArgsConstructor
//public class ProductWriter implements ItemWriter<Product> {
//    private final ProductRepository productRepository;
//
//
//    @Override
//    public void write(Chunk<? extends Product> chunk) throws Exception {
//        productRepository.saveAll(chunk);
//    }
//}
