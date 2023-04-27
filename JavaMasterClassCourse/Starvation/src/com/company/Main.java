package com.company;

// Thread starvation
// rarely have the opportunity to run and progress
// When we assign a high priority to the threads, suggests running it over others - still not guaranteed - It's just a suggestion
// So setting priorities can increase chances of starvation

// With deadlocks, order of locks required was important
// with starvation, which lock gets to run when a lock becomes available is important - want first come first serve but can't guarentee
    // use fair lock - try to be first come, first served

// synchro could be better becuase there might never have much waiting regardless
    // or don't care which pulls off the data
// also fairness is more process power


// live lock is similar to a deadlock
    // constantly active though and waiting for other threads to complete their task
// Since all are waiting for others to complete, none of them will process
    //EG thread 1 will loop until thread 2 completes and thread 2 loops until thread 1 stops.

import java.util.concurrent.locks.ReentrantLock;

public class Main {

//    private static Object lock = new Object();
    // for fairness lock
    // Only fairness is guaranteed for first come, etc. Not scheduling.
    // THis impacts performance more, because extra layer to find the most fair when heaps of threads
    private static ReentrantLock lock = new ReentrantLock(true); // true means the lock is fair - first come first served order

    public static void main(String[] args) {
	    Thread t1 = new Thread(new Worker(ThreadColor.ANSI_RED), "Priority 10");
	    Thread t2 = new Thread(new Worker(ThreadColor.ANSI_BLUE), "Priority 8");
	    Thread t3 = new Thread(new Worker(ThreadColor.ANSI_GREEN), "Priority 6");
	    Thread t4 = new Thread(new Worker(ThreadColor.ANSI_CYAN), "Priority 4");
	    Thread t5 = new Thread(new Worker(ThreadColor.ANSI_PURPLE), "Priority 2");

	    // Setting priority for threads
        // Also all these threads are not separate objects with separate locks?.
        // It is a global static, so they are all
        // Competing for the same lock
	    t1.setPriority(10);
	    t2.setPriority(8);
	    t3.setPriority(6);
	    t4.setPriority(4);
	    t5.setPriority(2);

	    t1.start();
	    t2.start();
	    t3.start();
	    t4.start();
	    t5.start();
    }

    private static class Worker implements Runnable {
        private int runCount = 1;
        private String threadColor;

        public Worker(String threadColor) {
            this.threadColor = threadColor;
        }

        @Override
        public void run() {
            for(int i = 0; i < 100; i++ ) {
                // took out synchronised so all threads could count together better
                lock.lock();
                try {
                    System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
                    // execute critical section of code
                } finally { // no matter what happens want to make sure the lock in released at some point
                    lock.unlock();
                }
            }
        }
    }
}
