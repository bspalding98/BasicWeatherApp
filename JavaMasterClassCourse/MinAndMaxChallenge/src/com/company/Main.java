package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);



        int min = 0;    //Could also do "Integer.Max_Value"
        int max = 0;    //Could also do "Integer.Min_Value"      --- Then would not need to do "|| (min/max == 0)

        while(true) {
            System.out.println("Can you please enter a number:");
            boolean IsAnInteger = scanner.hasNextInt();

            if(IsAnInteger) {
                int number = scanner.nextInt();
//                if((number < min) || (min == 0)) {
//                    min = number;
//                } else if(number > max) {
//                    max = number;
//                }
                min = ((number < min) || (min == 0)) ? number : min;
                max = ((number > max) || (max ==0)) ? number : max;        // Can just write. Math.max(number, max);
            } else {
                System.out.println("Invalid Value");
                break;
            }

            scanner.nextLine();     // Handle input? Why do you need to when I handle input with the (int number = scanner.nextInt();)
        }

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        scanner.close();
    }
}
