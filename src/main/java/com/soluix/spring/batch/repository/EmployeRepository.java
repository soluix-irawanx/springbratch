package com.soluix.spring.batch.repository;

import com.soluix.spring.batch.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends JpaRepository<Employee, String > {

}
