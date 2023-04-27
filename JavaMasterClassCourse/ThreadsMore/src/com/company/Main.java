package com.company;


// Interrupted two ways:
// by another thread calling the interrupt() which will terminate it
// by it reaching the end of the run()

// When we join a thread to another thread. It is saying not to start executing until this thread has terminated


// NEVER GUARANTEES ABOUT PRETTY MUCH EVERYTHING WITH THREAD AND TIMING AND INTERRUPTION


import static com.company.ThreadColor.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread.");


        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();

        new Thread(() -> System.out.println(ANSI_GREEN + "Hello from the anonymous class thread.")).start();

        Thread myRunnableThread = new Thread(new MyRunnable() { // THis whole thing here is the same as the line above if I put .start(); here and didn't assign it
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from the anonymous class's implementation of run()");  // THIs still prints straight away as above and outside scope
                try {
                    // int is the millis for how long to wait, because if antherThread was never interrupted the next code wouldn't run
                    anotherThread.join();   // Does this mean it doesn't run anything after this until anotherThread has terminated? - Yes I'm pretty sure
                    System.out.println(ANSI_RED + "AnotherThread terminated, or timed out, so I'm running again");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_RED + "I couldn't wait after all. I was interrupted");
                }
            }
        });

        myRunnableThread.start();
//        anotherThread.interrupt();  // This will terminate the thread

        System.out.println( ANSI_PURPLE + "Hello again from the main thread.");
    }
}
