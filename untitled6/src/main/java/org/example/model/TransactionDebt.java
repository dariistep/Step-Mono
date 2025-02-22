package org.example.model;

import java.util.Date;

public class TransactionDebt {
    private Long id;
    private String fromRakhunok;
    private String toRakhunok;
    private Date datetransaction;
    private int sumaDebt;
    private int transactionDebt1;
    private int balanceDebt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromRakhunok() {
        return fromRakhunok;
    }

    public void setFromRakhunok(String fromRakhunok) {
        this.fromRakhunok = fromRakhunok;
    }

    public String getToRakhunok() {
        return toRakhunok;
    }

    public void setToRakhunok(String toRakhunok) {
        this.toRakhunok = toRakhunok;
    }

    public Date getDatetransaction() {
        return datetransaction;
    }

    public void setDatetransaction(Date datetransaction) {
        this.datetransaction = datetransaction;
    }

    public int getSumaDebt() {
        return sumaDebt;
    }

    public void setSumaDebt(int sumaDebt) {
        this.sumaDebt = sumaDebt;
    }

    public int getTransactionDebt1() {
        return transactionDebt1;
    }

    public void setTransactionDebt1(int transactionDebt1) {
        this.transactionDebt1 = transactionDebt1;
    }

    public int getBalanceDebt() {
        return balanceDebt;
    }

    public void setBalanceDebt(int balanceDebt) {
        this.balanceDebt = balanceDebt;
    }
}