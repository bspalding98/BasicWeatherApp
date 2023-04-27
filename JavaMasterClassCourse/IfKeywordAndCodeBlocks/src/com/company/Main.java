package com.company;

public class Main {

    public static void main(String[] args) {

        boolean gameOver = true;
        int score = 5000;
        int levelCompleted = 5;
        int bonus = 100;

//        if (score == 5000)
//            System.out.println("Your score was 5000");
////        Can remove code block ("{") if there is only one line of code after if statement. only ONE line can work with that
////        Recommend to always use a code block for practice. it's easier to understand as well.
//
//        if (score < 5000 && score > 1000) {
//            System.out.println("your score was less than 5000 but greater than 1000");
//        } else if (score < 1000) {
//            System.out.println("Your score was less than 1000");
//        } else {
//            System.out.println("Got here");
//        }


        if (gameOver) { // if (gameOver) = if (gameOver == true)
            int finalScore = score + (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore);
        }
//        Above if control statement is an example of a scope

//        int savedFinalScore = finalScore;   // Does not work as you can access variables outside the code block but not from within
                                            // Since the code block IF control statement has ended the variable is now destroyed


//        CHALLENGE:
//        Print out a second score on the screen with the following
//        score set to 10000
//        levelCompleted set to 8
//        bonus set to 200
//        But make sure the first printout above still displays as well

        score = 10000;
        levelCompleted = 8;
        bonus = 200;

        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore);
        }

//        OR

        boolean newGameOver = true;
        int newScore = 10000;
        int newLevelCompleted = 8;
        int newBonus = 200;

        if (newGameOver) { // if (gameOver) = if (gameOver == true)
            int finalScore = newScore + (newLevelCompleted * newBonus);
            System.out.println("Your final score was " + finalScore);
        }


//        DO THE FIRST ONE as the second one you use more space (excess memory) be creating no non-needed variables - now 8 variables
//        Update variables in the first one so only 4 still


    }
}
