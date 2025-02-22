package org.example.service;
import org.example.model.Account;
import org.example.repository.AccountRepository;

import java.util.List;
import java.util.Optional;

public class AccountDebtService {
    private final AccountRepository accountRepository;

    public AccountDebtService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccounts() {
        Long userId = null;
        return accountRepository.findByOwnerId(userId);
    }

    public Optional<Account> getAccountById(Long accountId) {
        return accountRepository.findById(accountId);
    }

    public void updateAccountBalance(Account account) {
        accountRepository.save(account);
    }

    public double calculateTotalDebt(List<Account> accounts) {
        double totalDebt = 0;
        for (Account account : accounts) {
            if (account.getBalance() < 0) {
                totalDebt += Math.abs(account.getBalance());
            }
        }
        return totalDebt;
    }
    }