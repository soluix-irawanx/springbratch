package com.soluix.spring.batch.model.postgres;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "new_customers")
public class NewCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
}
