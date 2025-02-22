package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "user_data")//нова таблиця
public class Document {
    private int id;
    private String fileName;
    private byte[] content;
    private User user;/////?????????????????
    private Date uploadDate;
    public Document() {
        Long id;
        String filename;
        Byte [] content;
        String passport;////////////////////
        LocalDate uploadDate;
    }

    public void setName(String name) {
    }
    public void setBalance(double balance) {
    }

    public void setSurname(String surname) {
    }
//id прописать
    public void setEmail(String email) {
    }

    public void setPassword(String password) {
    }

    public void setDateRegister(LocalDate now) {
    }

    public String getSurname() {
        String surname = null;
        return  surname;
    }

    public String getName() {
        String name = null;
        return  name;
    }

    public LocalDate getDateRegister() {
        LocalDate dateRegister = null;
        return dateRegister;
    }

    public String getEmail() {
        String email = null;
        return email;
    }

    public String getPassword() {
        String password = null;
        return password;
    }
    public double getBalance () {
        double balance = 0;
        return balance;}

    public void setContent(byte[] bytes) {
    }

    public void setUser(User user) {
    }

    public void setFileName(String originalFilename) {
    }

    public void setContentType(String contentType) {
    }

    public void setUploadDate(Date date) {
    }

   public String getFileName() {
        return fileName;
   }

    public byte[] getContent() {
        return content;
    }

    public User getUser() {
        return user;
    }

    public int getId() {
        return id;
    }

    public Date getUploadDate() {
        return uploadDate;
    }
}

