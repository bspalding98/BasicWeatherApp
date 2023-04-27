package com.company;

public class Main {

    public static void main(String[] args) {

        int newScore = calculateScore("Boyd", 500);
        System.out.println("New score is " + newScore);

        calculateScore(75);
        calculateScore();

//        CHALLENGE:

        System.out.println(calcFeetAndInchesToCentimeters(0, 8));
        System.out.println(calcFeetAndInchesToCentimeters(118));
    }

    public static int calculateScore(String playerName, int score) {
        System.out.println("Player " + playerName + " scored " + score + " points");
        return score * 1000;
    }

    public static int calculateScore(int score) {
        System.out.println("Unnamed player scored " + score + " points");
        return score * 1000;
    }

    public static int calculateScore() {
        System.out.println("No player name, no player score");
        return 0;
    }


//    CHALLENGE:

    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {
        return feet >= 0 && inches >= 0 && inches <= 12 ? ((feet * 12) + inches) * 2.54 : -1;

//        OR
//        return feet < 0 || inches < 0 || inches > 12 ? -1 : ((feet * 12) + inches) * 2.54;
    }

    public static double calcFeetAndInchesToCentimeters(double inches) {
        double newInches = inches % 12;
        double feet = (int) (inches / 12);

        return inches >= 0 ? calcFeetAndInchesToCentimeters(feet, newInches) : -1;
    }

}
