package com.company;

public class Main {
    // Final field means you can set it once but must be by latest constructor initialisation
    // static final is usually only used for CONSTANTS.
        // WHY STATIC? -> because if it doesn't change it would be silly to not make it static and have to create an instance of the same value in every other place needed.
    // Just final for others because we want to still assign the value once. Where will CONSTANT it is pre assigned?

    public static void main(String[] args) {

//        SomeClass one = new SomeClass("one");
//        SomeClass two = new SomeClass("two");
//        SomeClass three = new SomeClass("three");
//
//        System.out.println(one.getInstanceNumber());
//        System.out.println(two.getInstanceNumber());
//        System.out.println(three.getInstanceNumber());
//
////        one.instanceNumber = 4; // Still cannot change even if it is public because it is final
//
//        System.out.println(Math.PI);
////        Math m = new Math(); // Cannot create instances as it is marked private. Reason why this is done is because all methods inside Math is static so don't need to make an instance.
//        // Can't even subclass Math because it is a final class. So can't do extend Math.
//        // Methods could be final as well to allow them to never be overwritten.
//
//        int pw = 674312;
//        Password password = new ExtendedPassword(pw);
//        password.storePassword();
//
//        password.letMeIn(1);
//        password.letMeIn(523266);
//        password.letMeIn(9773);
//        password.letMeIn(0);
//        password.letMeIn(-1);
//        password.letMeIn(674312);
//        // Problems actually comes if someone overrides the stored password in Password class.

        System.out.println("Main method called");
        SIBTest test = new SIBTest();
        test.someMethod();
        System.out.println("Owner is " + SIBTest.owner);

    }
}
