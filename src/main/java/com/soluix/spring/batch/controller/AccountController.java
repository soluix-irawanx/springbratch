package com.soluix.spring.batch.controller;

import com.soluix.spring.batch.model.postgres.Account;
import com.soluix.spring.batch.services.AccountService;
import com.soluix.spring.batch.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


@Controller
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;

    @PostMapping("/migration")
    public ResponseEntity<Map<String ,Object>> createProduct() {
       List<Account> accountList =accountService.migrationDataFromUser();

       Map<String, Object> response = new TreeMap<>();
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Users retrieved successfully");
        response.put("data", accountList);
        response.put("totalUsers", accountList.size());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getUsers() {
        List<Account> accountList = accountService.getAllDataAccount();

        Map<String , Object> response = new TreeMap<>();
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Users retrieved successfully");
        response.put("data", accountList);
        response.put("totalUsers", accountList.size());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/tes")
    public ResponseEntity<Map<String,Object>> demo(){
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Hello ini test");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
