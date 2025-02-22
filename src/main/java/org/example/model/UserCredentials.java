package org.example.model;


import jakarta.persistence.*;

@Entity
public class UserCredentials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private double balance;

    @OneToOne
    private User user;

    public UserCredentials(String email, String password) {
        this.email = email;
        this.password = password;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return email;
    }

    public void setUsername(String email) {
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

   /* public User getEmail() {
        return email;
    }

    public void User setEmail(Email email) {
        this.email = email;
    }*/


    /////////////////////////////////////////////////////



}
/*@Entity
public class UserCredentials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)



    @OneToOne
    private User user;
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
    private String password;*/

//////////////////////////////////

    /*public void UserCredentials (String patronymic, String name, String surname, int id, String code, String passport, LocalDate dateOfBirth, LocalDate dateRegister,
                                      String phone, String email, String password) {
        this.patronymic = patronymic;
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.code = code;
        this.passport = passport;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.dateRegister= dateRegister;
        this.phone= phone;
        this.email= email;*/
////////////////////////////////////////////////////////////

   /* public void setName(String name) {


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

    // Getters, setters, and constructors

    // Getters, setters, and constructors
}*/
