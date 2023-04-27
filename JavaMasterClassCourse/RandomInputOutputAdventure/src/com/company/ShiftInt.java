package com.company;

public class ShiftInt {
    private static final String ANSI_RESET = "\u0018[0m";
    private static final String ANSI_BLACK = "\u0018[30m";
    private static final String ANSI_RED = "\u0018[31m";
    private static final String ANSI_GREEN = "\u0018[32m";
    private static final String ANSI_YELLOW = "\u0018[33m";
    private static final String ANSI_BLUE = "\u0018[34m";
    private static final String ANSI_PURPLE = "\u0018[35m";
    private static final String ANSI_CYAN = "\u0018[36m";
    private static final String ANSI_WHITE = "\u0018[37m";

    public static void main(String[] args) {
        int x = 922342959;

        writeInt(x);
    }


    private static void display(int x) {
        String all = String.format("%32s", Integer.toBinaryString(x)).replace(" ", "0");
        String colouredBinary = all.substring(0, 24) + ANSI_GREEN + all.substring(24) + ANSI_RESET;
        int y = x & 0xFF;
        String output = String.format("%10d and 0xFF is %8s \t %10d is ",  y, Integer.toBinaryString(y), x) + colouredBinary;
        System.out.println(output);
    }

    private static void writeInt(int v) {
        int x;
        display(v >>> 24);
        display(v >>> 16);
        display(v >>> 8);
        display(v >>> 0);
    }
}

