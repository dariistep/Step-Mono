package org.example.controller;

import jakarta.servlet.http.HttpSession;
import org.example.model.User;
import org.example.model.UserCredentials;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//при відсутності реєстрації

    @Controller
    @RequestMapping("/auth")
    public class AuthController {
        @GetMapping("/login")
        public String showLoginForm(Model model) {
            String password= null;
            //Object password = new Object();
            String email = null;
            model.addAttribute("userCredentials", new UserCredentials( email, password));
            return "auth/login";
        }

        @PostMapping("/login")
        public String login(@ModelAttribute("userCredentials") UserCredentials userCredentials, HttpSession session) {
            // Логіка авторизації
            return "redirect:/";
        }

        @GetMapping("/registration")
        public String showRegistrationForm(Model model) {
            model.addAttribute("user", new User());
            return "auth/registration";
        }
    }
