package com.company;

public class StaticTest {
//    private int numInstance = 0;    // This makes first few lines of code make it only 1. Because it is reassigned to 0 everytime a new object is made
    private static int numInstance = 0; // Now that it is static. There is only one variable of numInstance and each object updates it. So once it is created once. It is done?
    private String name;

    public StaticTest(String name) {    // Changing this to static allows to use in main
        this.name = name;
        numInstance ++;
    }

    public int getNumInstance() {
        return numInstance;
    }

    public String getName() {
        return name;
    }
}
