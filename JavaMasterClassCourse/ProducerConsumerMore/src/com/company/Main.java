package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static com.company.Main.EOF;

//executorService API allows us to worry about the code and it handles most of the stuff for us like how the tasks will actually be run
// uses thread pools
// thread pool is a managed set of threads, reduces the overhead of thread creation, especially in application that uses a large number of threads
    // may also limit the number of threads that are active running at blocked at any one particular time
// Can make our own threadpool by making a class that implements a threadpool interface - but recommended to use the JVM in most situations
// Since it limits threads, it is possible that it might not run straight away as all the threads might be running already
//execute - new Thread(RUnnable)).start();
    // ex.execute(r);

// Must terminate application manually using executorService

// This is really only used with an application with a large number of threads - vital if there is a large number of threads - as it optimises thread management

// When we want to receive a value back from a thread we are executing in the background - use the submit()
// similar to runnable object - except that it can return a value
    // value can be returned as an object of type FUTURE

// difference between execute and submit it execute returns nothing and submit() returns a Future

// executor serivce contain ThreadSafe queues - perfect for producer consumer type applications
    // que classes implement blocking interface
    // FIFO - first in first out

public class Main {

    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        MyProducer  producer = new MyProducer(buffer, ThreadColor.ANSI_GREEN, bufferLock);
        MyConsumer  consumer = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE, bufferLock);
        MyConsumer  consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN, bufferLock);

        executorService.execute(producer);
        executorService.execute(consumer);
        executorService.execute(consumer2);

        // This had to wait until the others were finished as we only have 3 max of threads at the time and three above were running
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_GREEN + "I'm being printed form the Callable class");
                return "This is the callable result";
            }
        });
        // To get result
        try {
            // this blocks until the result is available - so when calling it from the main thread
            // our application would be frozen until results are available. So wouldn't use this is in UI application
            // With JAVAFX wouldnt use the services at all. instead use javafx concurrent package.
            System.out.println(future.get());
        } catch (ExecutionException e) {
            System.out.println("Something went wrong");
        } catch (InterruptedException e) {
            System.out.println("Thread running the task was interrupted");
        }

        // This is the orderly shutdown approach - waits
        executorService.shutdown(); // Will wait for any executing tasks to terminate before shutting down
        // Won't accept any new tasks after this

        // This will try hault any threads and shutdown immediately and throw away and tasks - no guarentee
        // Also possible it may never shutdown a task - so better for just shutdown()
//        executorService.shutdownNow();
    }
}

class MyProducer implements Runnable {
    private final List<String> buffer;
    private final String color;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};


        for(String num: nums) {
            try {
                System.out.println(color + " Adding... " + num);
                bufferLock.lock();  // acquire lock
                try {
                    buffer.add(num);
                } finally {
                    bufferLock.unlock();
                }
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
    }
}

class MyConsumer implements Runnable {
    private final List<String> buffer;
    private final String color;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }


    public void run() {
        int counter = 0;

        while(true) {
            if(bufferLock.tryLock()) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    System.out.println(color + "The counter = " + counter);
                    if (buffer.get(0).equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + " Removed " + buffer.remove(0));
                    }
                } finally {
                    bufferLock.unlock();
                }
            } else {
                counter ++;
            }
        }
    }
}
