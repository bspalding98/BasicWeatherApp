package com.company;

import static com.company.ThreadColor.ANSI_RED;

public class MyRunnable implements Runnable {
    // Second way of creating a Thread
    // Runnable interface
    // Only need to implement one method, the run method
    // So instead of implementing the run method of a class that subclasses thread
    // You can have any class implement the run interface and add a run() to the class

    @Override
    public void run() {
        System.out.println(ANSI_RED + "Hello from MyRunnable's implementation of run()");
    }
}
