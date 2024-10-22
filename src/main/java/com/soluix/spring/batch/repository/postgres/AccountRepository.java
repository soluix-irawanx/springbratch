package com.soluix.spring.batch.repository.postgres;

import com.soluix.spring.batch.model.postgres.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
