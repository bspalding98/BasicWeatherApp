package com.company;

public class Main {

    public static void main(String[] args) {
        int myVariable = 50;            // Statement is the entire line; By adding the data type, expression and finishing off with semicolon
        myVariable++;                  // Also is a statement as has semicolon to make it a statment
        System.out.println("This is a test");   // A statement as well. Using methods as there is a method call and a semicolon at the end

//        Semicolon is needed to complete a line in most cases and make a statement - exceptions for that
//        Statements do not need to be on the one line EG.
        System.out.println("This is" +
                " another" +
                " still more."); // These three lines are one statement as semicolon is down the bottom

//        multiple statements on the one line
        int anotherVariable = 50;
        myVariable--;
        System.out.println("This is another one");    // Does not recommend though

//        White space is the space in your expressions and statements to make it aware of separate things, and clarify meaning, make it also neater and more readable
//        Java ignores white spaces between things like expressions. "measure = 50" java reads as "measure=50"

//        Indenting makes coding a lot more readable ("logical flow") and understand.
    }
}
