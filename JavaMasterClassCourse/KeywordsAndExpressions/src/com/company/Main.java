package com.company;

public class Main {

    public static void main(String[] args) {

        // Expression for what 100 miles to 100 kilometres
        //Need a mile is equal to 1.609344 kilometres
        double kilometres = (100 * 1.609344);   // This whole line is an expression not including "double". It's variables values and operators.
//                                                  Adding a data type "Double" It creates a statement with the combination of the ";"

        int highscore = 50;
        if (highscore ==  50) { // Expression "highscore == 50"
            System.out.println("This is an expression");    // This is calling a method
        }

//        ENTIRE line minues data type and semicolon is the expression pretty much. Most things in brackets for example if statement and sout methods

//        CHALLENGE: Write down what parts of the code are expressions

        int score = 100;                                    // score = 100
        if (score > 99) {                                   // score > 99 - Part in brackets
            System.out.println("You got the high score!");   // "You got the high score!" - Part in brackets
            score = 0;                                      // score = 0
        }
    }
}
