package com.company;

public class Main {

    public static void main(String[] args) {

        byte byteValue = 121;
        short shortValue = 5675;
        int intValue = 43;
        long longValue = 50000L + (10L * (byteValue + shortValue + intValue));

        System.out.println("Challenge answer is: " + longValue);

    }
}

