package com.bank;

import java.time.LocalDateTime;

public class Transaction {

	private String type;
    private double amount;
    private double balance;
    private LocalDateTime date;

    public Transaction(String type, double amount, double balance) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.date = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return date + " | " + type + " | Amount: " + amount + " | Balance: " + balance;
    }
}

