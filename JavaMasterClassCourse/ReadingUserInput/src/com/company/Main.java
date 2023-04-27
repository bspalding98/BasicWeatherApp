package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your year of birth");

        boolean hasNextInt = scanner.hasNextInt();     // Checks if next number is an integer or not, if it is not. will return false

        if(hasNextInt) {
            int yearOfBirth = scanner.nextInt();
            scanner.nextLine(); // Handle next line character. When you press enter java looks for one. if not one will skip name input below and treat as this handle.

            System.out.println("Enter your name: ");
            String name = scanner.nextLine();

            int age = 2021 - yearOfBirth;

            if(age >= 0 && age <= 100) {
                System.out.println("Your name is " + name + ", and you are " + age + " years old.");
            } else {
                System.out.println("Invalid year of birth");
            }
        } else {
            System.out.println("Unable to parse year of birth");
        }


        scanner.close();
    }
}
