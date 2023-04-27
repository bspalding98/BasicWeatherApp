package com.company;

// Rarely would ever use. static() is always called before the constructor regardless if it is after.

public class SIBTest {
    public static final String owner;

    static {
        owner = "Tim";
        System.out.println("SIBTest static initialisation block called");
    }

    public SIBTest() {
        System.out.println("SIB constructor called");
    }

    static {
        System.out.println("2nd initialisation block called");
    }

    public void someMethod() {
        System.out.println("someMethod called");
    }
}
