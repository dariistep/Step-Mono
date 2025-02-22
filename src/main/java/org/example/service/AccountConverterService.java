package org.example.service;

import org.example.model.Account;
import org.example.model.User;
import org.example.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountConverterService {
    private final AccountRepository accountRepository;



    public AccountConverterService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAccountsByUser(User user) {
        return accountRepository.findByUser(user);
    }

}
