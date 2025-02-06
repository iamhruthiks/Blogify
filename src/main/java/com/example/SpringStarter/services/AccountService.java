package com.example.SpringStarter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringStarter.models.Account;
import com.example.SpringStarter.repositories.AccountRepository;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    
    public Account save(Account account) {
        return accountRepository.save(account);
    }
}
