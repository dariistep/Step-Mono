package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegistrationView extends JFrame {
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton registerButton;

    public RegistrationView() {
        setTitle("Registration");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel(new GridBagLayout());
        contentPane.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPane.add(new JLabel("First Name:"), gbc);

        gbc.gridx = 1;
        nameField = new JTextField(20);
        contentPane.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        contentPane.add(new JLabel("Last Name:"), gbc);

        gbc.gridx = 1;
        surnameField = new JTextField(20);
        contentPane.add(surnameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        contentPane.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        emailField = new JTextField(20);
        contentPane.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        contentPane.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        passwordField = new JPasswordField(20);
        contentPane.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        registerButton = new JButton("Register");
        contentPane.add(registerButton, gbc);

        setContentPane(contentPane);
    }

    public String getNameInput() {
        return nameField.getText();
    }

    public String getSurnameInput() {
        return surnameField.getText();
    }

    public String getEmailInput() {
        return emailField.getText();
    }

    public String getPasswordInput() {
        return new String(passwordField.getPassword());
    }

    public void setRegisterButtonListener(ActionListener listener) {
        registerButton.addActionListener(listener);
    }
}
