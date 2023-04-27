package com.company;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

// Need to ensure the code inside the catch code block does not cause exceptions itself.
    // EG. run a method that errors. then you catch it but in the catch re the same method again. Will error the second time and there is no catch for the second error.
// Keep catch blocks as simple as possible in order to minimise chance of another error.

// Multiple catch blocks. If there is an exception. Code will look through the catches and see if it is there.
// If it is. It will run that code and they skip all other catches

// multiple exceptions: catch(arithmeticException | NoSuchElementException e)   | = a bitwise OR which is used for this. idk why

public class Example {
    public static void main(String[] args) {
        try {
            int result = divide();
            System.out.println(result);
        } catch (ArithmeticException e ) {
            System.out.println(e.toString());   // Shows where it happened which is NoSuchElement exception down below
            System.out.println("Unable to perform division, autopilot shutting down");
        }
    }

    private static int divide() {
        int x;
        int y;
//        try {
//            x = getInt();
//            y = getInt();
//        } catch (NoSuchElementException e) {
//            throw new ArithmeticException("No suitable input");
//        }
//        System.out.println("x is " + x + ", y is " + y);
//        try{
//            return x/y;
//        } catch (ArithmeticException e) {
//            throw new ArithmeticException("Attempt to divide by zero");
//        }

        try {
            x = getInt();
            y = getInt();
            System.out.println("x is " + x + ", y is " + y);
            return x/y;
        } catch (NoSuchElementException e) {
            throw new ArithmeticException("No suitable input");
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Attempt to divide by zero");

        }
    }

    private static int getInt() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer");
        while(true) {
            try {
                return s.nextInt();
            } catch(InputMismatchException e) {
                // Go round again. Read past the end of line in the input first
                s.nextLine();   // Used to catch the enter input (rest of the line) as the buffer only extracts the number in nextInt()
                System.out.println("Please enter a number using only the digits 0 to 9");
            }
        }
    }
}