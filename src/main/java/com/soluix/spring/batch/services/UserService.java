package com.soluix.spring.batch.services;

import com.soluix.spring.batch.model.mysql.User;
import com.soluix.spring.batch.repository.mysql.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional("mysqlTransactionManager")
    public List<User> getAllDataUser(){

        return userRepository.findAll();
    }

}
