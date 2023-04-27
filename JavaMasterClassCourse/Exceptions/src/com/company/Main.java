package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    // Two approaches to dealing with errors
    // LBYL and EAFP
    // Look before you leap, Easy to ask for forgiveness and permission

    // LBYL EG. Checking exception not null before going on
    // EAFP going forward anf trapping and exception if something goes wrong
    // usually use LBYL in Java


    // Still debate about which one is better
        // Both are better because it just depends on the situation.
        // In java is more common to check first but still

    // Exception
        // Event which occurs during an execution of a program and disrupts the flow of normal operations. Something went wrong somewhere

    // Normally when catching an exception. You would specific which subclass exception to catch - Not good to be generic with exceptions.
    // If specific known exactly what went wrong. Also other reasons not mentioned yet.

    // No point catching an exception if your code cannot do anything sensible with it.


    public static void main(String[] args) {
//        int x = 98;
//        int y = 0;
//        System.out.println(divideLBYL(x, y));
//        System.out.println(divideEAFP(x, y));
//        System.out.println(divide);
        int x = getIntEAFP();
        System.out.println("x is " + x);
    }

    private static int getInt() {
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }

    // Longer than EAFP
    private static int getIntLBYL() {
        Scanner s = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Please enter an integer ");
        String input = s.next();
        // Error handling with LBYL
        for(int i=0; i<input.length(); i++) {
            if(!Character.isDigit(input.charAt(i))) {   // Testing each character to make sure it's a number . Even handles decimals since it's each char.
                isValid = false;    // breaking out of false if not true
            }
        }
        // Returning results based off error handling above
        if(isValid) return Integer.parseInt(input);
        return 0;
    }

    // Shorter than LBYL
    private static int getIntEAFP() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer");
        try { return s.nextInt(); }
        catch(InputMismatchException e) { return 0; }
    }










    // Shorter
    private static int divideLBYL(int x, int y) {
        if(y != 0) return x/y;
        return 0;
    }

    //Longer
    private static int divideEAFP(int x, int y) {
        try { return x/y; }
        catch (ArithmeticException e) { return 0; }
    }

    private static int divide(int x, int y) { return x/y; }
}
