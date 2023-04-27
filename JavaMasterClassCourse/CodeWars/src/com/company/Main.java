package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> equations = new ArrayList<>();
        for(int i = 1; i <= 10; i ++) {
            equations.add(i + " * " + num + " = " + num * i + "\n");
        }
    }

    public static String multiTable(int num) {
        ArrayList<String> equations = new ArrayList<>();
        for(int i = 1; i <= 10; i ++) {
            equations.add(i + " * " + num + " = " + num * i + "\n");
        }
        return equations;
    }
}
