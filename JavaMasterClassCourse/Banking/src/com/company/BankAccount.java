package com.company;

public class BankAccount {

    private String firstName;
    private String lastName;
    private double balance;

    public static final int CHECKING = 1;
    public static final int SAVINGS = 2;

    private int accountType;

    public BankAccount(String firstName, String lastName, double balance, int typeOfAccount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.accountType = typeOfAccount;
    }

    // Branch argument is true if the customer is performing the transaction
    // at a branch, with a teller.
    // It's false if the customer is performing the transaction at an ATM
    public double deposit(double amount, boolean branch) {
        return balance += amount;
    }

    // Branch argument is true if the customer is performing the transaction
    // at a branch, with a teller.
    // It's false if the customer is performing the transaction at an ATM
    public double withdraw(double amount, boolean branch) {
        // Cannot withdraw more then 499 at an atm
        if((amount > 500) && (!branch)) { throw new IllegalArgumentException(); }
        return balance -= amount;
    }

    public double getBalance() {
        return balance;
    }


    public boolean isChecking() {
        return accountType == CHECKING;
    }

    // More methods that use firstName, listName, and perform other functions
}
