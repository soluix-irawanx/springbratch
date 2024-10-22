package com.soluix.spring.batch.model.mysql;

import com.soluix.spring.batch.model.postgres.Account;
import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
@Table(name = "usersSource")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;


}