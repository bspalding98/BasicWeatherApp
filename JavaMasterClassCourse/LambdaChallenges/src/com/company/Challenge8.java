package com.company;

/**
 * There are many interfaces in the Java SDK, and sometimes we can use a lambda expression
 * instead of creating and instance that implements the interface we want to use
 *
 * Given a specific interface, how can we tell whether we can map a lambda
 * expression to it? What's the criteria that has to be met?
 */

public class Challenge8 {

    //Answer

    // Has to be a function interface. It can have only a single method that must be implemented

    // A functional interface can contain more than one method, but all the methods but one must have
        // default implementations

    // Most of the time, the documentation for an interface will state whether it's a functional interface



    // Q2. Can we use a lambda expression to represent an instance of the java.util.concurrent.Callable interface?

    // Answer:
    // The Callable interface has only one method that has to be implemented - the call() method.
    // So we can use lambda for it. The documentation also states that it's a functional interface.


    // Q3. Is the java.util.Comparator interface a functional interface?

    //Answer:
    // Yes it is. Despite containing over 10 methods, only one method has to be implemented - compare().
        // Because of that, it's a functional interface
}
