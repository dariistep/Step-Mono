package org.example.model;

public class Account {
    private Long id;
    private String number;
    private double balance;
    private double debt;
    private User owner;
    private String type;
    private User User;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUser(User user) {
        this.User= user;
    }
}

/*package org.example.model;

public class Account {
    private Long id;
    private String number;
    private double balance;
    private User owner;

    public double getBalance() {
        return 0;
    }

    public void setBalance(double v) {
    }

    public void setUser(User user) {
    }

    public long getNumber() {
        return 0;
    }

    public char[] getType() {
        String accountType = "Поточний";
        return accountType.toCharArray();
    }

    public boolean getId() {
        return this.id != null;
    }

    public char[] getDebt() {


    }
}*/
