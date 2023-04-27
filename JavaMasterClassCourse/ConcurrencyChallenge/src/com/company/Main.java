package com.company;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        BankAccount account = new BankAccount("12345-678", 1000.00);

        // CHALLENGE 1 - Could also just do .start() in both of them. Instead of assigning a variable
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                    account.deposit(300.00);
                    account.withdraw(50.00);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                    account.deposit(203.75);
                    account.withdraw(100.00);
            }
        });

        t1.start();
        t2.start();


        //CHALLENGE 2 - in BankAccount Class
    }
}
