package com.soluix.spring.batch.model.mysql;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "old_customers")
public class OldCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email;
    private String phoneNumber;
}
