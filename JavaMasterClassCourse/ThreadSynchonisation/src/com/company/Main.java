package com.company;


// synchronisation: - pretty much prevents a race condition / interference
//ONE WAY:
    // Synchronised mehtods and statements
        // methods sycnhronised are - only one thread can run it at a time. SO if others want to, they will be
        // suspended until the thread ends
        // Only one sychronised method can run at once and only on one thread at a time
        // So all other synchronised methods will also be suspended
        // But if not synchronised it can still run. can cause problems like:
        //. Interleave?
        // Only prevents inside the methods within them, but not outside, can still be thread interference (race codition)

// To synchronise a method, just need to add keyword to a method declaration

// Cannot synchronise constructors - That should be just common sense as to why
    // Can synchronise every other type of method

// ANOTHER WAY:
// synchronised a block of statement rather than a type of method
    // Every java object has an intrinsic lock or monitor
    // synchro a block of statements that work with an object by forcing threads to acquire the object lock before
    // they execute the statement block
    // Only one thread can hold the lock at one time, so if other threads want the lock, they will be suspended until the running thread releases it

// THE OBJECT is updated:
    // SO if one thread accesses the object and adds 20 and assigns it (stores it), the next one will start at the value added


// Can also use strings as synchro lock for object but you need to ensure the string has one value pointer
    // below string color won't work because it has two different values
    // If it was just cyan it would then work

// critical section used when discussed threads
    // refers to the code that is referencing a shared resource like a variable
    // only one thread at a time should be able to execute a critical section

// Also see term Thread Safe
    // when class or method is thread safe
    // The dev has synchronised all the critical sections in the code, so we as a dev
    // don't have to worry about the thread interference
    // So if it isn't thread safe, we would be responsibly for sychro if we use multiple threads


// NO UI in javafx is thread safe
    // Why all code is force on javafx runtime thread - so since only one thread can modify the UI components
    // there won't be any thread interference

// When synchronised code - ONLY DO THE CODE THAT NEEDS TO BE DONE. - KEEP TO AN ABSOLUTE MINIMUM
    // just synchro critical sections of code


public class Main {

    public static void main(String[] args) {
        // Creating two countdowns and assigning Threads individual ones, a bad attempt at synchronisation
        // however in real world applications this won't work
        // EG bank accounts
            // Need one instance to keep integrity
        // So wee need multiple threads to change it but cannot cause a race condition
//        Countdown countdown1 = new Countdown();
        Countdown countdown = new Countdown();

        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread 1");
        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }
}

class Countdown {


    // Cannot use the counter variable I because it's primitive type
    // And primitive types don't have locks

    private int i;
    public void doCountdown() {
        // enhanced switch
        String color = switch (Thread.currentThread().getName()) {
            case "Thread 1" -> ThreadColor.ANSI_CYAN;
            case "Thread 2" -> ThreadColor.ANSI_PURPLE;
            default -> ThreadColor.ANSI_GREEN;
        };

        // Only one thread can hold the color lock at one time
        // This is wrong because it's a local variable, and they are stored in the ThreadStack
        // So each thread will have a copy of color so there are essentially two locks
            // So need an object that the threads will share, so they are both competing for the same lock
        // ONLY Exception is the STRING variable for local - because they are reused in JVM...??

        // WHEN USING A LOCAL OBJECT VARIABLE:
        // Object reference are stored in the ThreadStack
            // Value is stored on the heap though
        // So since they will each make their own copy of the object (reference will be difference)
            // There will be no interference even though there is just one value on the heap
        // ThreadStacks only hold primitive types, object references, and function references
        synchronized (this) {   // this means the countdown object the threads share (the class we are in)
            for (i = 10; i > 0; i--) {
                System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
            }
        }
    }
}

class CountdownThread extends Thread {
    private final Countdown threadCountdown;

    public CountdownThread(Countdown countdown) {
        threadCountdown = countdown;
    }

    public void run() {
        threadCountdown.doCountdown();
    }
}
