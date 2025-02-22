package org.example.controller;

import org.example.model.Account;
import org.example.model.User;

public class AccountService {
    public Account createDefaultAccount(User user) {
        return new Account();
    }
}
