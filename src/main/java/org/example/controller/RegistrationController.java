package org.example.controller;

import org.example.model.User;
import org.example.view.RegistrationView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.example.service.RegistrationService;

import java.sql.*;
import java.time.LocalDate;


@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private final RegistrationService registrationService;
    private final RegistrationView registrationView;
    //private RegistrationView view;
    private final User user;

    public RegistrationController(RegistrationService registrationService, RegistrationView registrationView, User user) {
        this.registrationService = registrationService;
        this.registrationView = registrationView;
        this.user = user;

        registrationView.setRegisterButtonListener(e -> registerUser());
    }






    private void registerUser() {
        String name = registrationView.getNameInput();
        String surname = registrationView.getSurnameInput();
        String email = registrationView.getEmailInput();
        String password = registrationView.getPasswordInput();

        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPassword(password);
        user.setDateRegister(LocalDate.now());

        saveUserToDatabase(user);
    }
    //база даних обов'язкова

    private void saveUserToDatabase(User user) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password")) {
            String sql = "INSERT INTO user_data (code, surname, name, patronymic, passport, dateregister, dateofbirth, phone, email, password) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, generateCode());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getName());
            statement.setString(4, ""); // Patronymic
            statement.setString(5, ""); // Passport
            statement.setDate(6, Date.valueOf(user.getDateRegister()));
            statement.setDate(7, null); // DateOfBirth
            statement.setString(8, ""); // Phone
            statement.setString(9, user.getEmail());
            statement.setString(10, user.getPassword());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String generateCode() {
        // kod
        return "1234567890";
    }
}
