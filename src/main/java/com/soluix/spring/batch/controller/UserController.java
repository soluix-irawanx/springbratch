package com.soluix.spring.batch.controller;

import com.soluix.spring.batch.model.mysql.User;
import com.soluix.spring.batch.services.AccountService;
import com.soluix.spring.batch.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Controller
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getUsers() {
        List<User> userList = userService.getAllDataUser();

        Map<String , Object> response = new TreeMap<>();
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Users retrieved successfully");
        response.put("data", userList);
        response.put("totalUsers", userList.size());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
