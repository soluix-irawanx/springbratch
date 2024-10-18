package com.soluix.spring.batch.repository;

import com.soluix.spring.batch.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
