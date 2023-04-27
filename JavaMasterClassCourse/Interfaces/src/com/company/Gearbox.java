package com.company;

public class Gearbox {
    private boolean clutchIsIn;

//    public void operateClutch(String inOrOut) {
//        this.clutchIsIn = inOrOut.equalsIgnoreCase("in");
//    }

//    Change it to this
    public void operateClutch(boolean inOrOut) {
        this.clutchIsIn = inOrOut;
    }
    // Problem is now that this is changed. Other code that relied on it will be broken as it originally needed a string.

    // Interface is like a commitment, a contract if you will that the method signatures and variables and constants will not change.
}
