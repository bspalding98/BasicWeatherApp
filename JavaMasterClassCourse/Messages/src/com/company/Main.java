package com.company;

// METHODS that can only be called within synchronised code
// weight, notify, notify all methods


// Deadlock -
    // synchro'd read and write method
    // So when one loops, it cannot change the value of empty because the thread is blocked
    // We write but we can now never change empty value so while loop is forever???

// We 100% needed to have both synchronised
    // So need to use wait, notify, and notify all methods to get around it
// Wait & notify & notify all;
    // When a thread calls a wait(), it will suspend execution and release locks holding until another thread issues something important has happened
    // So the other thread would use the notify() or notify all()


// Always call wait() in a loop
    // Because it will wait for a notify (when it returns)
    // once it gets it, it will run the loop again (the condition we are interested in) if the condition hasn't changed
// normally use notifyall() unless dealing with a situation with multiple threads doing similar tasks coz of performance hit
    // cannot pass in parameters in notify()


// below:
// Each thread now waits and releases its lock on the message object when the loop condition passes
// Gives the other thread the opportunity to read
    // when notifyall() is called, the threading waiting can received it and can now run again.

// threads can be suspended when calling one line of code
    // like one line calls a big method, so can suspend when running through the method lines


// IMPORTANT NOTES  (atomic operations) - happen all at once
// A thread can't be suspended in the middle of doing them:::
// Reading or writing reference variables
    // EG myObj1 = myObj2 --- Cannot be suspended in the middle of that
// A thread cannot be suspended reading and writing variables
    // except type long and doubles
        // EG my int = 10 cannot be suspended - my long = 12341234123412341234 - could because they can potentially take two or more operations so can be suspended between them maybe
// Reading and writing all variables that are volatile

// arraylist are not threadSafe - not synchronised
    // Means if multi threads can access at same time, we need to be responsible for synchornising the code that uses the arraylist
    // OR
    // can call collections.synchroniseList (not 100% on the syntax) after arraylist and pass in the arraylist.

// Vector class is synchronised so wouldn't need to worry about that



import java.util.Random;

public class Main {
    // Going to have two threads:
    // 1 to produce messages
    // one to consume messages

    public static void main(String[] args) {
        Message message = new Message();
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();
    }
}

class Message {
    private String message;
    private boolean empty = true;

    // BOTH methods are synchronised
    // Because only one synchro method can be executed at once
    // And we don't want it to read and write at the same time.

    // Used by consumer to read a message
    public synchronized String read() {
        // loop until there is a message to read
        while(empty) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        // true indicates we read the message
        empty = true;
        notifyAll();
        return message;
    }

    // Use by a producer to write a message
    public synchronized void write(String message) {
        // loop until there isn't a message to write

        // So essentially this having it in this loop says:
        // when something it written wait, so the read() can read it then it will notify here
        // Then here is empty to it wont run wait() and will write again, and vice versa with read()
        while(!empty) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        // false indicates we have written something
        empty = false;
        this.message = message;
        notifyAll();
    }
}

class Writer implements Runnable {  // (producer class)
    private final Message message;

    public Writer(Message message) {
        this.message = message;
    }

    public void run() {
        String[] messages = {
                "Humpty Dumpty sat on a wall",
                "Humpty Dumpty had a great fall",
                "All the king's horses and all the king's men",
                "Couldn't put Humpty together again"
        };

        // Creat random delay - to simulate what would happen in a real world app (chance for consumer to run) - why slept it
        Random random = new Random();

        for(String message : messages) {
            this.message.write(message);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch(InterruptedException e) {

            }
        }
        message.write("Finished");
    }
}

class Reader implements Runnable {
    private final Message message;

    public Reader(Message message) {
        this.message = message;
    }

    public void run() {
        Random random = new Random();
        for(String latestMessage = message.read(); !latestMessage.equals("Finished"); latestMessage = message.read()) {
            System.out.println(latestMessage);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {

            }
        }
    }
}
