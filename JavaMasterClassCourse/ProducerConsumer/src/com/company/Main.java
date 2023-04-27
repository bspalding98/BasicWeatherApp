package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import static com.company.Main.EOF;

// Synchronisation drawbacks
// 1st - threads that are blocked, waiting to execute synchronised code, they cannot be interrupted, so they are stuck just waiting there to get the lock
    // Can lead to problems - seen in later lectures
// 2nd is synchronised block must be within the same method, cannot nstart in one and end in another
// 3rd cannot test if objects intrinsic lock is available or find out any other info
    // Also if lock isn't available we can't time out after wait for the lock for a while
    // When we reach the beginning of the synchro block, we can either get the lock and continue exe or block at that code and wait for lock
// 4th - There isn't a set order in which the JVM will choose which thread gets the block

// Can use classes that implemented java.util.current.locks interface or something prevent interference without using synchronisation
    // so won't have the drawbacks mentions above


// Think advantages of try {} finally {} with lock and unlock is that if you have code with several unlocks, can have just one with try and finally

// Thread can test to see if a lock is available using the try lock()
    // if lock is available, it will get lock
    // if it isn't it won't block and we can even have it execute something else

// Reentrant lock constructor accepts a fairness parameter
    // When set to true, teh lock class will try be fair to give lock to whoever has been waiting the longest
// can check numbers waiting. getquededwait() ?


//excutors serivce API allows us to worry about the code and it handles most of the stuff for us like how the tasks will actually be run
// uses thread pools
// thread pool is a managed set of threads, reduces the overhead of thread creation, especially in application that uses a large number of threads
    // may also limit the number of threads that are active running at blocked at any one particular time
// Can make our own threadpool by making a class that implements a threadpool interface - but recommended to use the JVM in most situations
// Since it limits threads, it is possible that it might not run straight away as all the threads might be running already
//execute - new Thread(RUnnable)).start();
    // ex.execute(r);

public class Main {

    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();    // This is unsynchronised so there is interference? - Arraylist is not synchronised
        ReentrantLock bufferLock = new ReentrantLock(); // If thread is already holding a reentrantlock when it reaches code that requires same lock, can continue executing, doesn't need to get the lock again
        MyProducer  producer = new MyProducer(buffer, ThreadColor.ANSI_GREEN, bufferLock);
        MyConsumer  consumer = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE, bufferLock);
        MyConsumer  consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN, bufferLock);

        // Only need to do this since we implemented Runnable interface to class and created a run()
        new Thread(producer).start();
        new Thread(consumer).start();
        new Thread(consumer2).start();
    }
}

class MyProducer implements Runnable {  // implementing runnable because we want to run it on a background thread
    private final List<String> buffer;
    private final String color;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run() {
        // Synchronising the buffer is done because arraylist at not synchronised objects
        // So they could suspend between adding code and could be problems?
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        // using classes
        for(String num: nums) {
            try {
                System.out.println(color + " Adding... " + num);
                // will either contain the lock if can or if something else has it. will be suspended until it can claim the lock
                bufferLock.lock();  // acquire lock
                try {
                    buffer.add(num);
                    // only gotten put unlock() in once place, and if have another exception not being dealt with. this will still happen not matter what
                } finally {
                    bufferLock.unlock();
                }
                // If we forget to release 0 threads waiting for the lock will be blocked forever
//                bufferLock.unlock();    // release lock (we are responsible for releasing the lock unlike synchronised block)

                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        bufferLock.lock();
        try {
            buffer.add("EOF");
        } finally {
            bufferLock.unlock();
        }
//        for(String num: nums) {
//            try {
//                System.out.println(color + " Adding... " + num);
//                synchronized (buffer) {
//                    buffer.add(num);
//                }
//
//                Thread.sleep(random.nextInt(1000));
//            } catch (InterruptedException e) {
//                System.out.println("Producer was interrupted");
//            }
//        }
//
//        System.out.println(color + "Adding EOF and exiting...");
//        synchronized (buffer) {
//            buffer.add("EOF");
//        }
    }
}

class MyConsumer implements Runnable {
    // Real world App wouldnt loop like this
    // Would just make it sleep for a while then check again
    // or use a wait and notify approach
    private final List<String> buffer;
    private final String color;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }


    // check if locked or not so thread doesn't forever block - wouldn't use realistically in this program. Just showcasing it
    public void run() {
        int counter = 0;

        while(true) {
            // don't want another consumer or producer to change the arraylist one the consumer checks whether the buffer is empty
            // So all arraylist stuff to happen collectively at once
            if(bufferLock.tryLock()) {  // if true execute code
                try {
                    if (buffer.isEmpty()) {
                        continue;   // THis doesn't call the unlock() after else{}
                    }
                    System.out.println(color + "The counter = " + counter);
                    if (buffer.get(0).equals(EOF)) {
                        System.out.println(color + "Exiting");
                        // Don't remove EOF entry because if we did buffer would be empty and other Consumer threads would run infinite while loop
                        break;
                    } else {
                        System.out.println(color + " Removed " + buffer.remove(0));
                    }
                } finally {
                    bufferLock.unlock();
                }
            } else {    // This exact reason if why we don't want to print anything. Can have millions of counts in this little code
                counter ++;
            }
        }
    }

    // using classes
//    public void run() {
//        while(true) {
//            // don't want another consumer or producer to change the arraylist one the consumer checks whether the buffer is empty
//            // So all arraylist stuff to happen collectively at once
//            bufferLock.lock();
//            try {
//                if (buffer.isEmpty()) {
//                    continue;   // THis doesn't call the unlock() after else{}
//                }
//                if (buffer.get(0).equals(EOF)) {
//                    System.out.println(color + "Exiting");
//                    // Don't remove EOF entry because if we did buffer would be empty and other Consumer threads would run infinite while loop
//                    break;
//                } else {
//                    System.out.println(color + " Removed " + buffer.remove(0));
//                }
//            } finally {
//                bufferLock.unlock();
//            }
//        }
//    }

//    public void run() {
//        while(true) {
//            // don't want another consumer or producer to change the arraylist one the consumer checks whether the buffer is empty
//            // So all arraylist stuff to happen collectively at once
//            synchronized (buffer) {
//                if (buffer.isEmpty()) {
//                    continue;
//                }
//                if (buffer.get(0).equals(EOF)) {
//                    System.out.println(color + "Exiting");
//                    // Don't remove EOF entry because if we did buffer would be empty and other Consumer threads would run infinite while loop
//                    break;
//                } else {
//                    System.out.println(color + " Removed " + buffer.remove(0));
//                }
//            }
//        }
//    }
}
