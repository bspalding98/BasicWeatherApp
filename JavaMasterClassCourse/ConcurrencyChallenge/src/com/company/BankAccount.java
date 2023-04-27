package com.company;

// Challenge 3 - trick question, no changes

//Challenge 4 - Reentrant Lock
    // ensure we initialise it in the constructor and now there is just one lock so when deposit lock() runs. you cannot withdraw, etc (Compete for the same lock)
    // Also ensure you do a try{} with a finally{} so it will always release the lock and not create a deadlock or something

// Challenge 6 - trick question, added in status variable to methods
    // Since it is a local variable it is already ThreadSafe
    // Coz stores on ThreadStack the local variables so each has their own so won't interfere


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private Lock lock;

    private double balance;
    private final String accountNumber;

    public BankAccount(String accountNumber, double balance) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.lock = new ReentrantLock();
    }

    // Challenge 2:
    // this
//    public synchronized void deposit(double amount) {
//        balance += amount;
//    }
//
//    public synchronized void withdraw(double amount) {
//        balance -= amount;
//    }
    // OR - First better in this instance because all the method is synchronised
//    public void deposit(double amount) {
//       synchronized (this) {
//           balance += amount;
//       }
//    }
//
//    public void withdraw(double amount) {
//        synchronized (this) {
//            balance -= amount;
//        }
//    }

    // Challenge 4
//    public void deposit(double amount) {
//        lock.lock();
//        try {
//            balance += amount;
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public void withdraw(double amount) {
//        lock.lock();
//        try {
//            balance -= amount;
//        } finally {
//            lock.unlock();
//        }
//    }


    // Challenge 5: - using trylock() with timeout
    public void deposit(double amount) {
        boolean status = false;

        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) { // These parameters are the timeOut duration implemented
                try {
                    balance += amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else System.out.println("Could not get the lock");
        } catch (InterruptedException e) {  // This is to handle trylock() as it cna through this exception

        }
        System.out.println("Transaction status = " + status);
    }


    public void withdraw(double amount) {
        boolean status = false;

        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance -= amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else System.out.println("Could not get the lock");
        } catch (InterruptedException e) {

        }
        System.out.println("Transaction status = " + status);
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber() {
        System.out.println("Account number = " + accountNumber);
    }
}
