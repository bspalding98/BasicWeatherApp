
package com.company;

public class Main {

            public static void main(String[] args) {

//                boolean gameOver = true;
//                int score = 800;
//                int levelCompleted = 5;
//                int bonus = 100;
//
//                calculateScore(gameOver, score, levelCompleted, bonus); // This argument is expecting 4 parameters (4 values of data) based off the method.


//                score = 10000;
//                levelCompleted = 8;
//                bonus = 200;
//
//                calculateScore(gameOver, score, levelCompleted, bonus);

//                OR

//                System.out.println(calculateScore(false, 800, 5, 100));  // Will print the -1 value as it would not otherwise due to method only returning and not printing

                int highscore = calculateScore(true, 800, 5, 100);
                System.out.println("Your final score was " + highscore);

                highscore = calculateScore(true, 10000, 8, 200);
                System.out.println("Your final score was " + highscore);


//                CHALLENGE

                String playerName = "Boyd Spalding";

                int highScorePosition = calculateHighScorePosition(1500);
                displayHighScorePosition(playerName, highScorePosition);

                highScorePosition = calculateHighScorePosition(900);
                displayHighScorePosition("Boyd Spalding", highScorePosition);   // Just to show you can enter in name as literal variable as does not change. However cannot
                                                                                            // enter in literal for 2nd argument as it changes each time

                highScorePosition = calculateHighScorePosition(400);
                displayHighScorePosition(playerName, highScorePosition);

                highScorePosition = calculateHighScorePosition(50);
                displayHighScorePosition(playerName, highScorePosition);
            }

//            public static void calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) { // These are the parameters. There are 4 defined parameters
//
//                if (gameOver) { // if (gameOver) = if (gameOver == true)
//                    int finalScore = score + (levelCompleted * bonus);
//                    finalScore += 2000;
//                    System.out.println("Your final score was " + finalScore);
//                }
//            }
//            Using void means there is no return value from method

            public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) { // Must declare the data type returning instead of void

//                if (gameOver) { // if (gameOver) = if (gameOver == true)
//                    int finalScore = score + (levelCompleted * bonus);
//                    finalScore += 2000;
//                    System.out.println("Your final score was " + finalScore);
//                    return finalScore;
//                } else {
//                    return -1;
//                }

//            Must return a value. So if the else statement did not exist, it would error as if the if statement was false. Nothing would return
//            OR
                if (gameOver) { // if (gameOver) = if (gameOver == true)
                    int finalScore = score + (levelCompleted * bonus);
                    finalScore += 2000;
                    return finalScore;
                }

                return -1;
//                THIS ONE IS WAY BETTER IN THIS INSTANCE. When something return the method ends. so no else is needed
//                returning -1 as in programming it indicates and error. an invalid value or value not found.
            }



//            CHALLENGE

            public static int calculateHighScorePosition(int playerScore) {
//                if (playerScore >= 1000) {
//                    return 1;
//                } else if (playerScore >= 500) {
//                    return 2;
//                } else if (playerScore >= 100) {
//                    return 3;
//                }
//
//                return 4;

//                OR

                int position = 4;   // Assuming position 4 will be returned pretty much it is like the else so if nothing works it returns that

                if (playerScore >= 1000) {
                    position = 1;
                } else if (playerScore >= 500) {
                    position = 2;
                } else if (playerScore >= 100) {
                    position = 3;
                }

                return position;

//                PROBABLY rather do the first one as I understand it. I would just have to check to see how uni likes to do it
            }

            public static void displayHighScorePosition(String playerName, int highScorePosition) {
                System.out.println(playerName + " managed to get into position " + highScorePosition +
                        " on the high score table");
            }


        }
