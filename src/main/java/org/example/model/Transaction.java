package org.example.model;

import java.time.LocalDateTime;

public class Transaction {
    private Long id;
    private double amount;
    private double debt;
    private LocalDateTime dateTime;
    private Account account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}


/*package org.example.model;

public class Transaction {
    public char[] getId() {
    }

    public char[] getAmount() {
    }

    public char[] getDebt() {
    }
}*/
