package org.example.service;

import org.example.model.Account;
import org.example.model.User;
import org.example.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountCredService {
    private final AccountRepository accountRepository;



    public AccountCredService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAccountsByUser(User user) {
        return accountRepository.findByUser(user);
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public void saveAccount(Account account) {
        accountRepository.save(account);
    }
}
