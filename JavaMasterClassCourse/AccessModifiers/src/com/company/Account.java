package com.company;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountName; // These are changed from public to private so they cannot have their values manually changed in the main(). Fraud can then happen - makes it more secure
    private int balance = 0;
    private List<Integer> transactions;

    public Account(String accountName) {
        this.accountName = accountName;
        this.transactions = new ArrayList<>();
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if(amount > 0) {
            this.transactions.add(amount);
            this.balance += amount;
            System.out.println(amount + " deposited. Balance is now " + this.balance);
        }
        else System.out.println("You cannot deposit a negative amount");
    }

    public void withdrawal(int amount) {
        int withdrawal = -amount;       // This is done because you don't want people to have to enter in a physical negative value. Just a value to withdraw.
        if(withdrawal < 0) {
            this.transactions.add(withdrawal);
            this.balance += withdrawal;
            System.out.println(amount + " withdrawn. Balance is now " + this.balance);
        }
        else System.out.println("You cannot input a negative amount to withdraw");
    }

    public void calculateBalance () {   // Do not need for loop as you already update this.balance in withdrawl() and deposit()
//        this.balance = 0;
//        for(Integer i : transactions) {
//            this.balance += i;
//        }
        System.out.println("Current balance is " + this.balance);
    }
}
