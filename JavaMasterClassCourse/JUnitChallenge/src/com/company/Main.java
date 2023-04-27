package com.company;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {

    public static void main(String[] args) {
        Utilities util = new Utilities();
        System.out.println(util.removePairs("AABCDDEFF"));

        char[] word = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(util.everyNthChar(word, 2));
    }
}
