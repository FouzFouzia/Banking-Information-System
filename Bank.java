package com.bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Bank {

	private Map<String, User> users = new HashMap<>();
    private Random random = new Random();

    public void registerUser(Scanner sc) {
        System.out.print("Enter Username: ");
        String username = sc.next();
        if (users.containsKey(username)) {
            System.out.println("User already exists!");
            return;
        }

        System.out.print("Enter Password: ");
        String password = sc.next();

        User user = new User(username, password);
        users.put(username, user);
        System.out.println("Registration Successful!");
    }

    public void loginUser(Scanner sc) {
        System.out.print("Enter Username: ");
        String username = sc.next();
        System.out.print("Enter Password: ");
        String password = sc.next();

        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login Successful!");
            userMenu(sc, user);
        } else {
            System.out.println("Invalid Credentials!");
        }
    }

    private void userMenu(Scanner sc, User user) {
        while (true) {
            System.out.println("\n===== USER DASHBOARD =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer Funds");
            System.out.println("5. View Statement");
            System.out.println("6. Logout");
            System.out.print("Choose: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    createAccount(user);
                    break;
                case 2:
                    deposit(sc, user);
                    break;
                case 3:
                    withdraw(sc, user);
                    break;
                case 4:
                    transfer(sc, user);
                    break;
                case 5:
                    user.viewTransactions();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private void createAccount(User user) {
        String accNo = "AC" + (10000 + random.nextInt(90000));
        Account account = new Account(accNo);
        user.setAccount(account);
        System.out.println("Account created successfully!");
        System.out.println("Account Number: " + accNo);
    }

    private void deposit(Scanner sc, User user) {
        if (user.getAccount() == null) {
            System.out.println("Please create account first!");
            return;
        }
        System.out.print("Enter Amount: ");
        double amt = sc.nextDouble();
        user.getAccount().deposit(amt);
    }

    private void withdraw(Scanner sc, User user) {
        if (user.getAccount() == null) {
            System.out.println("Please create account first!");
            return;
        }
        System.out.print("Enter Amount: ");
        double amt = sc.nextDouble();
        user.getAccount().withdraw(amt);
    }

    private void transfer(Scanner sc, User user) {
        if (user.getAccount() == null) {
            System.out.println("Please create account first!");
            return;
        }

        System.out.print("Enter Receiver Username: ");
        String toUser = sc.next();
        User receiver = users.get(toUser);

        if (receiver == null || receiver.getAccount() == null) {
            System.out.println("Receiver not found!");
            return;
        }

        System.out.print("Enter Amount: ");
        double amt = sc.nextDouble();

        if (user.getAccount().transfer(receiver.getAccount(), amt)) {
            System.out.println("Transfer Successful!");
        }
    }
	
}
