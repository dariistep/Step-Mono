package org.example.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "user_data")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String surname;
    private String name;
    private String patronymic;
    private String passport;
    private LocalDate dateRegister;
    private LocalDate dateOfBirth;
    private String phone;
    private String email;
    private String password;
    private double balance;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Account> accounts;

    public User() {
    }

    public User(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.dateRegister = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public LocalDate getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(LocalDate dateRegister) {
        this.dateRegister = dateRegister;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public char[] getIdentificationCode() {
        return this.code.toCharArray();
    }

    public char[] getPassportData() {
        return this.passport.toCharArray();
    }

    public void setId(long id) {
    }
}

/*package org.example.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "user_data")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private String surname;
    private String name;
    private String patronymic;
    private String passport;
    private LocalDate dateRegister;
    private LocalDate dateOfBirth;
    private String phone;
    private String email;
    private String password;
    private double balance;
    private List<Account> accounts;


    public User() {
         int id;
         String code;
         String surname;
         String name;
         String patronymic;
         String passport;
         LocalDate dateRegister;
         LocalDate dateOfBirth;
         String phone;
         String email;
         String password;
         double balance;


    }

    public User(String name, String surname, String email, String password) {//новий конструктор від UserService.
    }

    public void setName(String name) {
    }
    public void setBalance(double balance) {
    }

    public void setSurname(String surname) {
    }

    public void setEmail(String email) {
    }

    public void setPassword(String password) {
    }

    public void setDateRegister(LocalDate now) {
    }

    public String getSurname() {
        return  surname;
    }

    public String getName() {
        return  name;
    }

    public LocalDate getDateRegister() {
        return dateRegister;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    public double getBalance () {return balance;}

    public char[] getIdentificationCode() {
        return this.code.toCharArray();
    }

    public char[] getPassportData() {
        return this.passport.toCharArray();
    }

    // Getters, setters, and constructors
}*/