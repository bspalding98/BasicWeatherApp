package com.company;

public class Main {

    public static void main(String[] args) {

//        System.out.println("10,000 at 2% interest = " + calculateInterest(10000d, 2d));
//        System.out.println("10,000 at 2% interest = " + calculateInterest(10000d, 3d));
//        System.out.println("10,000 at 2% interest = " + calculateInterest(10000d, 4d));
//        System.out.println("10,000 at 2% interest = " + calculateInterest(10000d, 5d));

//        Using for loop to shrink code and make it more readable through automation with for statement/loop
//        For used when you know the given numbers of times you want to loop something

        for(int i = 0; i < 5; i ++){  // init = intial pretty much, termination - happens when false, increment  - expression evoked after each loop
            System.out.println("loop + " + i + " hello");
        }

//        CHALLENGE 1:

//        for (int i=2; i<9; i++) {
//            System.out.println("10,000 at " + i + "% interest = " + calculateInterest(10000, i));
//        }

        System.out.println("********************");

//        CHALLENGE 2:

//        for(int i=8; i>=2; i--) {
//            System.out.println("10,000 at " + i + "% interest = " + String.format("%.2f",calculateInterest(10000, i)));
//        }

//        Good to use stuff like I and J as they are just indexes and are destroyed after the statement finishes.


//        CHALLENGE 3:
        int count = 0;

        for(int i = 7; i < 180; i ++) {
            if(isPrime(i)) {
                count ++;
                System.out.println(i);
                if(count == 10) {
                    break;
                }
            }
        }

    }

    public static double calculateInterest(double amount, double interestRate) {
        return (amount * (interestRate / 100));
    }


//    CHALLENGE 3:

    public static boolean isPrime(int n) {
        if(n == 1) {
            return false;
        }

        for(int i = 2; i <= n/2; i++) {     // i <= (long) Math.sqr(n) - This is way better because you the code is looped like 3 times less
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
