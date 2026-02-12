package com.bank;

public class User {
	
	private String username;
    private String password;
    private Account account;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void viewTransactions() {
        if (account == null) {
            System.out.println("No account found!");
            return;
        }
        account.showTransactions();
    }
}


