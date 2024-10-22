package com.soluix.spring.batch.repository.postgres;

import com.soluix.spring.batch.model.postgres.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
