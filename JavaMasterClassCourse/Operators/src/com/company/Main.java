package com.company;

import jdk.swing.interop.SwingInterOpUtils;

public class Main {

    public static void main(String[] args) {

        int result = 1 + 2;     // 1 + 2 = 3
        System.out.println("1 + 2 = " + result);
        int previousResult = result;
        System.out.println("previousResult = " + previousResult);
        result -= 1;    // 3 - 1 = 2
        System.out.println("3 - 1 = " + result);
        System.out.println("previousResult = " + previousResult);

        result = result * 10;   // 2 * 10 = 20
        System.out.println("2 * 10  = " + result);

        result = result / 5;    // 20 / 5 = 4
        System.out.println("20 / 5 = " + result);

        result = result % 3;    // the remainder of (4 % 3) = 1
        System.out.println("4 % 3 = " + result);

        // results = result + 1
        result ++;  // 1 + 1 = 2
        System.out.println("1 + 1 = " + result);

        result --;  // 2 - 1 = 1
        System.out.println("2 - 1 = " + result);

        // result = result + 2;
        result += 2;    // 1 + 2 = 3
        System.out.println("1 + 2 = " + result);

        // result = result * 10
        result *= 10;   // 3 * 10 = 30
        System.out.println("3 * 10 = " + result);

        // result = result / 3
        result /= 3;    // 30 / 3 = 10
        System.out.println("30 / 3 = " + result);

        // result = result - 2
        result -= 2;    // 10 - 2 = 8
        System.out.println("10 - 2 = " + result);

//        boolean isAlien = false;
//        if (isAlien == true)
//            System.out.println("It is not an alien!");
//            System.out.println("And I am scared of aliens");    // This still prints

//        DO THIS

        boolean isAlien = false;
        if (isAlien == false) {
            System.out.println("It is not an alien!");
            System.out.println("And I am scared of aliens");    // This still prints
        }

//        int topScore = 100;
//        if (topScore == 100) {
//            System.out.println("You got the high score!");
//        }
//
//        int topScore = 100;
//        if (topScore != 100) {
//            System.out.println("You got the high score!");
//        }
//
//        int topScore = 100;
//        if (topScore > 100) {
//            System.out.println("You got the high score!");
//        }

        int topScore = 80;
        if (topScore < 100) {
            System.out.println("You got the high score!");
        }

        int secondTopScore = 60;
        if ((topScore > secondTopScore) && (topScore < 100)) {  // && = AND operator - also parentheses to make it readable
            System.out.println("Greater than second top score and less than 100");
        }

        if ((topScore > 90) || (secondTopScore <= 90)) {
            System.out.println("Either or both of the conditions are true");
        }

        boolean isCar = false;
        if (isCar = true) {
            System.out.println("This is not supposed to happen");   // Still printed as it assigned new boolean true.
        }

//        int newValue = 50;
//        if (newValue = 50) {
//            System.out.println("This is true"); // This assignment does not work as it's assigning Int not boolean
//        }

        if (!isCar) {   // !isCar = isCar == false
            System.out.println("isCar is not true");
        }

        boolean wasCar = isCar ? true : false;
        if (wasCar) {
            System.out.println("WasCar is true");
        }

        int ageOfClient = 20;
        boolean isEighteenOrOver = (ageOfClient == 20) ? true : false;    // Assignment boolean of (ageOfClient == 20) to isEighteenOrOver

//        Challenge

        double firstDoubleValue = 20.00d;
        double secondDoubleValue = 80.00d;
        double total = (firstDoubleValue + secondDoubleValue) * 100.00d;
        System.out.println(total);

        double remainder = total % 40.00d;
        System.out.println(remainder);

        boolean isRemainderEmpty = (remainder == 0) ? true : false;
        System.out.println(isRemainderEmpty);

        if (!isRemainderEmpty) {
            System.out.println("Got some remainder");
        }
    }
}
