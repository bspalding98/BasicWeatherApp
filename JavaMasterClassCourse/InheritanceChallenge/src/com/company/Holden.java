package com.company;

import java.util.Scanner;

public class Holden extends Car{
//    fields or instance variables or member variables
    private int horsePower;

//    constructor / setters
    public Holden(int moving, boolean gears, int horsePower) {
        super(moving, true, gears);
        this.horsePower = horsePower;
    }

//    S
    public int isManual() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Is your car a manual or not");
        boolean carIsManual = scanner.nextBoolean();
        if(carIsManual) {
            scanner.close();
            return 1;
        }
        scanner.close();
        return -1;
    }

//    getters

    @Override
    public boolean isGears() {
        if(isManual() == 1) {
            System.out.println("Car is a manual");
            return true;
        }
        System.out.println("Car is an automatic");
        return false;
    }

}
