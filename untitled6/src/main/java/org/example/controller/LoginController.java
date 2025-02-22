package org.example.controller;

import org.example.model.User;
import org.example.service.UserService;
import org.example.view.LoginView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//
@Controller
@RequestMapping("/login")
public class LoginController
{
    private final UserService userService;
    private final LoginView loginView;

    @Autowired
    public LoginController(UserService userService, LoginView loginView) {
        this.userService = userService;
        this.loginView = loginView;
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user) {
        // Перевірка даних користувача з бази даних
        if (isValidUser(user)) {
            // Перенаправлення на сторінку додатку
            return "redirect:/app";
        } else {
            // Повернення на сторінку входу з помилкою
            return "login";
        }
    }
    private boolean isValidUser(User user) {
        // Отримання користувача з бази даних за логіном
        User dbUser = userService.getUserByEmail(user.getName());//ім'я користувача

        // Перевірка, чи збігається пароль користувача з паролем в базі даних
        return dbUser != null && dbUser.getPassword().equals(user.getPassword());
    }
}