package com.company;

// When a thread is holding a lock but is blocking by another  and then can block each other when waiting for each other

// Prevent
// All threads must try to obtain locks in the same order - like below. runs now.
    // before had thread 2 try to get lock 2 first than 1, and it deadlocked
// Another solution is lock object instead of synchronised {}


public class Main {

    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }




    private static class Thread1 extends Thread {
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 1: Has lock 1");
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e) {

                }
                System.out.println("Thread 1: waiting for lock 2");
                synchronized (lock2) {
                    System.out.println("Thread 1: Has lock 1 and lock 2");
                }
                System.out.println("Thread 1: Released lock 2");
            }
            System.out.println("Thread 1: Released lock1. Exiting...");
        }
    }

    private static class Thread2 extends Thread {
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 2: Has lock 1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
                System.out.println("Thread 2: Waiting for lock 2");
                synchronized (lock2) {
                    System.out.println("Thread 2: Has lock 1 and lock 2");
                }
                System.out.println("Thread 2: released lock 2");
            }
            System.out.println("Thread 2: Released lock 1. Exiting...");
        }
    }


}


