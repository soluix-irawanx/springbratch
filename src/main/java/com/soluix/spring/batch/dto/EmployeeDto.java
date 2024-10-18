package com.soluix.spring.batch.dto;

public record EmployeeDto(
        String employeeId,
        String fullName,
        String jobTitle,
        String department,
        String businessUnit,
        String gender,
        String ethnicity,
        Integer age
) {
}
