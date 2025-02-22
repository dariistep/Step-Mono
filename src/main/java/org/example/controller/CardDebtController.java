package org.example.controller;

import org.example.model.Account;
import org.example.service.AccountDebtService;
import org.springframework.ui.Model; // Виправлено імпорт
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Додано анотацію для контролера
public class CardDebtController {
    private final AccountDebtService accountService;

    // Конструктор без помилок
    public CardDebtController(AccountDebtService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/cards")
    public String cards(Model model) {
        List<Account> accounts = accountService.getAllAccounts();
        model.addAttribute("accounts", accounts); // Виправлено додавання атрибута
        return "cards";
    }
}
