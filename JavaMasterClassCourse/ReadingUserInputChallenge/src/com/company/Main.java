package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = 0;
        int sum = 0;

        while(count != 10) {        // Be better to use for loop since know the amount but he said not to????
            System.out.println("Please enter number #" + (count + 1));
            boolean isInteger = scanner.hasNextInt();

            if(!isInteger) {
                System.out.println("Invalid Number");
                scanner.nextLine();     // Handles end of line (enter key)
            } else {
                int number = scanner.nextInt();
                count ++;
                sum += number;
            }
        }

        System.out.println("You have entered " + count + " numbers and the sum of them were " + sum);
        scanner.close();
    }
}
