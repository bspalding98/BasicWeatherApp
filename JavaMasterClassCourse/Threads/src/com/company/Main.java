package com.company;

// NEVER assume the threads will run in a certain order. There is always a chance that they won't
// ONLY ONE INSTANCE OF A THREAD CAN BE RUN ONCE. Need to make a new instance of the thread if want to run it again.

// Better to implement Thread than extend because if you extend you can only do that once, so you cannot extend anything else
// if you implement you can implement several things and still extends so it makes the class more usable and flexible.

// Runnable or subclass
// Most time people use runnable as it's more convenient and flexible
    // Many APIs want runnable?
// Anon runnnable instances are most convenient coz of lambda

// A thread will terminate when it returns from its run(). Either because it reaches end or returns something
    // Remember to also do start() so JVM calls it.
        // Won't crash however but it's not great because it will run from the thread it's called in . so normally main instead of through the class thread


// INTERRUPT A THREAD WHEN we want it to stop what's doing and do something else
    // More often or not, you do that because you want it to terminate
        //EG> Thread monitoring a buffer for data that another threads fetching
        // When there is no more data to fetch, can interrupt the monitoring thread
// Two ways to know they are interrupted
    // Catch interrupted exception
    // When the run() doesn't call any catches for interrupted exception. It should call the interrupted() periodically to see if it has been interrupted
// HOW DOES ONE THREAD INTERRUPT ANOTHER
    // Call the interrupt() on the thread instance that it wants to interrupt,
        // Which then means it will need a reference to the thread instance to be able to call that.

import static com.company.ThreadColor.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread.");

        // Creating a class for a thread, good if using more than once (named class)
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        // This enables the JVM to run the run() from the thread
        anotherThread.start();

        // If only using once, only need an anonymous class
        // When using anon class you need to start the thread straight away.
        new Thread(() -> System.out.println(ANSI_GREEN + "Hello from the anonymous class thread.")).start();

//        Thread myRunnableThread = new Thread(new MyRunnable());
        // Can also have an anonymous class implement runnable and pass an instance of it to the constructor
        Thread myRunnableThread = new Thread(new MyRunnable() { // THis whole thing here is the same as the line above if I put .start(); here and didn't assign it
            @Override
            public void run() {
//                super.run();    // still runs from myRunanble class because of super
                System.out.println(ANSI_RED + "Hello from the anonymous class's implementation of run()");
            }
        });



        myRunnableThread.start();

        System.out.println( ANSI_PURPLE + "Hello again from the main thread.");
    }
}
