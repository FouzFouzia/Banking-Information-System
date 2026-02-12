package com.bank;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\n===== BANKING INFORMATION SYSTEM =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    bank.registerUser(sc);
                    break;
                case 2:
                    bank.loginUser(sc);
                    break;
                case 3:
                    System.out.println("Thank you for using Banking System!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}


