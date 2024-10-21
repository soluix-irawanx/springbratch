package com.soluix.spring.batch.repository.mysql;

import com.soluix.spring.batch.model.mysql.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
