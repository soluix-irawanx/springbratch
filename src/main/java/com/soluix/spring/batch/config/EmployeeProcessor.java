package com.soluix.spring.batch.config;

import com.soluix.spring.batch.dto.EmployeeDto;
import com.soluix.spring.batch.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeProcessor implements ItemProcessor<EmployeeDto, Employee> {
    @Override
    public Employee process(EmployeeDto employeeDto) throws Exception {
        if (employeeDto.jobTitle().equals("Vice President")){
            return null;
        }
        return mapEmployee(employeeDto);
    }

    private Employee mapEmployee(EmployeeDto employeeDto){
        return Employee.builder()
                .employeeId(employeeDto.employeeId())
                .age(employeeDto.age())
                .gender(employeeDto.gender())
                .businessUnit(employeeDto.businessUnit())
                .fullName(employeeDto.fullName())
                .enthnicity(employeeDto.ethnicity())
                .jobTitle(employeeDto.jobTitle())
                .department(employeeDto.department())
                .build();
    }
}
