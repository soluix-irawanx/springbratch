package com.soluix.spring.batch.services;

import com.soluix.spring.batch.model.postgres.Account;
import com.soluix.spring.batch.model.mysql.User;
import com.soluix.spring.batch.repository.postgres.AccountRepository;
import com.soluix.spring.batch.repository.mysql.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AccountRepository accountRepository;


    @Transactional("postgresTransactionManager")
    public List<Account> getAllDataAccount(){
        return accountRepository.findAll();
    }

    @Transactional("postgresTransactionManager")
    public List<Account> migrationDataFromUser(){
        List<User> userList = userRepository.findAll();
        List<Account> accountList = new ArrayList<>();

        // manipulation data from userList
        for (User user: userList){
            Account account = new Account();
            int lastNumIndexPhone = user.getPhoneNumber().length()-1;

            account.setUsername(user.getFullName()+user.getPhoneNumber().substring(6,lastNumIndexPhone));
            account.setEmail(user.getFullName()+lastNumIndexPhone+"@gmail.com");
            account.setPassword(user.getFullName().trim()+user.getPhoneNumber());
            account.setStatus("Active");

            accountList.add(account);
        }
        accountRepository.saveAll(accountList);
        return accountList;
    }
}
