package com.soluix.spring.batch.repository.mysql;

import com.soluix.spring.batch.model.mysql.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
