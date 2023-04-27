package com.company;

// Live locks

// solution to live lock depends on code
    // doesn't have to be a loop involved. any that have to wait and aren't blocked

// Another problem
// Slipped condition
// specific type of race condition (aka thread interference)
// Can occur when a thread can be suspended between reading a condition and acting on it.
    // EG: reading file
    // 1 checks status and get ok -suspends instead of reading the data
    // 2 checks status gets ok, reads EOF and sets EOF and terminates
    // 1 tries to run again and read data and gets and exception and crashes

// Solution is still the same as any of interference
    // if code is already synchro'd
    // placement might be a problem or the order

// Atomic action
    // completes the action, cannot suspend at all when starting to execute the action
    // reading and writing reference variables
    // myObject 1 = myObject cannot
    // reading writing primitive variables except long and double
    // my int = 10; cannot
    // my double = 1.123 can
// still need to synchronise because of the way Java manages memory, it's possible to get memory consistency errors when multiple threads can read and write the same variable
// Each thread has a CPU cache, which can contain copies of values that are in the main memory
// faster to read form cache, can improve performance. good if only one CPU, but most don't and each CPU have a cache
    // so can get out of sync making the error

// THis is where volatile vairables come in. - tells compiler to only write to main memory as can be updated outside scope? Or main and cache?
// Without them the above won't guarentee to write and update the value back to the main memory.
// volatile ensures this always happens, and reading will get the latest value

//Consider this example:
//
//int i = 5;
//System.out.println(i);
//The compiler may optimize this to just print 5, like this:
//
//System.out.println(5);
//However, if there is another thread which can change i, this is the wrong behavior. If another thread changes i to be 6, the optimized version will still print 5.
//
//The volatile keyword prevents such optimization and caching, and thus is useful when a variable can be changed by another thread.

// need synchro for a volatile variable if more than one thread will access it
// synchro on volatile depends on code
// long and double is common since they aren't atomic

// java has classes that allow us to not worry about interference or memory consistency in some cases
// java.util.concurrent.atomic - classes to ensure reading and writing variables are atomic
// can use AtmoicIntteger counter instead of just a normal int counter
    // when using Atmoic types, don't have to worry about thread interference
// java docs state the clases in java.util.concurrent.atomic package "support lock-free thread-safe programming on single variables"
// only use atomicIntger in specific situations. check decs for things. Lecture 284 for docs

// Atomic classes are really only meant to be used when a value is being incremented or decremented - code using a loop counter or generating a sequence of numbers, etc.
// has compareAndSet() - if equals, true and overwrites


public class Main {

    public static void main(String[] args) {
	final Worker worker1 = new Worker("Worker 1", true);
	final Worker worker2 = new Worker("Worker 2", true);

	final SharedResource sharedResource = new SharedResource(worker1);

	new Thread(new Runnable() {
        @Override
        public void run() {
            worker1.work(sharedResource, worker2);
        }
    }).start();

	new Thread(new Runnable() {
        @Override
        public void run() {
            worker2.work(sharedResource, worker1);
        }
    }).start();
    }
}
