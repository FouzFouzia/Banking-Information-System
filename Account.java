package com.bank;

import java.util.ArrayList;
import java.util.List;

public class Account {
	
	private String accountNumber;
    private double balance;
    private List<Transaction> transactions = new ArrayList<>();

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }
        balance += amount;
        transactions.add(new Transaction("Deposit", amount, balance));
        System.out.println("Deposit Successful! Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            System.out.println("Insufficient balance!");
            return;
        }
        balance -= amount;
        transactions.add(new Transaction("Withdraw", amount, balance));
        System.out.println("Withdrawal Successful! Balance: " + balance);
    }

    public boolean transfer(Account receiver, double amount) {
        if (amount <= 0 || amount > balance) {
            System.out.println("Insufficient balance!");
            return false;
        }
        balance -= amount;
        receiver.balance += amount;

        transactions.add(new Transaction("Transfer Sent", amount, balance));
        receiver.transactions.add(new Transaction("Transfer Received", amount, receiver.balance));
        return true;
    }

    public void showTransactions() {
        System.out.println("\n----- Account Statement -----");
        System.out.println("Account No: " + accountNumber);
        System.out.println("Balance: " + balance);
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

	

}
