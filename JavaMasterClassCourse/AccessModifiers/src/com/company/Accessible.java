package com.company;

interface Accessible {
    int SOME_CONSTANT = 100;
    public void methodA();
    void methodB();
    boolean methodC();

    // Interface is set to package-private so is accessible to all classes within the package. - In com.company
    // Constant - public static final.
    // They are all accessible to all classes that implement this interface?

    // ALL INTERFACE METHODS MUST BE PUBLIC - Because you need to implement them. Can make them package-private by making interface package-private

}
