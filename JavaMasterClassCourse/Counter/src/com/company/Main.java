package com.company;

// Going to have two threads counting down from 10 using a countdown object
// Normally would have classes in separate files but just because small just put it together

// If you keep running main() you will see the order of what is run is never guarenteed

// Thread can be supposed between steps.

// objects are stored in a heap which are shared. so threads shared memory

// This EXAMPLE below is called interference or a race condition
    // wouldn't be a problem if they were only reading the resource

public class Main {

    public static void main(String[] args) {
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

    // changing local i in for loop to a private variable
    // THis has caused the countdown for loop to not duplicate
        // The reason is that with this created field. Both Threads now share the same heaps "i" I think??? Line: Countdown countdown = new Countdown();
    // When is was local before. The doCountdown() was called for each Thread so i memory was created separately on ThreadStackTrace?
    // This created one space of memory for i since it's now an instacne variable
    private int i;  // This doesn't make each thread count down from 10. 10 is duplicated, the rest is individual. - after each one skips the ones that are printed
                    // thread 2 skips all the ones thread 1 prints. and sometimes 3 will print after 1 or something else like that

    public void doCountdown() {
        // enhanced switch
        String color = switch (Thread.currentThread().getName()) {
            case "Thread 1" -> ThreadColor.ANSI_CYAN;
            case "Thread 2" -> ThreadColor.ANSI_PURPLE;
            default -> ThreadColor.ANSI_GREEN;
        };

        // Suspension examples of the thread
        // Just before the decrementing i
        // Just before the condition
        // Just before printing out the value
        // Even more with print statement concatenating, etc.
        for (i = 10; i > 0; i--) {
            System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
        }
    }
}

class CountdownThread extends Thread {
    private Countdown threadCountdown;

    public CountdownThread(Countdown countdown) {
        threadCountdown = countdown;
    }

    public void run() {
        threadCountdown.doCountdown();
    }
}
