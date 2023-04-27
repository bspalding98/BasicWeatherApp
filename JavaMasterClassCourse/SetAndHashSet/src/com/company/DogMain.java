package com.company;

public class DogMain {
    public static void main(String[] args) {
        Labrador rover = new Labrador("Rover");
        Dog rover2 = new Dog("Rover");

        System.out.println(rover2.equals(rover));   //true Lab is an instanceof Dog
        System.out.println(rover.equals(rover2));   //false Dog is not an instance of Lab

        // Best way to fix is not override the equal() in Labrador class.
        // Because we are not overriding the equals()
        // TO make sure it cannot be overridden in subclasses we mark it as final in Dog class.
    }
}
