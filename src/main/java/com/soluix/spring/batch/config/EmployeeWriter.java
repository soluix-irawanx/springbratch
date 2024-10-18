package com.soluix.spring.batch.config;

import com.soluix.spring.batch.entity.Employee;
import com.soluix.spring.batch.repository.EmployeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

@RequiredArgsConstructor
public class EmployeeWriter implements ItemWriter<Employee> {
    private final EmployeRepository employeRepository;

    @Override
    public void write(Chunk<? extends Employee> chunk) throws Exception {
        employeRepository.saveAll(chunk);
    }
}

