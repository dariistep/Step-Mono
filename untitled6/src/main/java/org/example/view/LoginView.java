package org.example.view;

import org.example.model.User;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class LoginView {
    public void addUserToModel(Model model) {
        model.addAttribute("user", new User());
    }
}