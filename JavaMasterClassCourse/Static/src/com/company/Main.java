package com.company;

public class Main {
    // Static methods and fields. Belong to the class. Not the instances of the class. So there is only one copy made

    // In main everything needs to be static because you cannot call one something that is nonstatic unless you make an instance of it first??
    // And since the stuff is in main already. The only way to make it work in the static main() is to create a Main instance. But you wouldn't do that inside main itself.
    // that's is silly and not need since we have static

    public int multiplier = 7;

    public static void main(String[] args) {    // THis is static because when Java tries to run code. It needs a static so it can access it.
                                                // Otherwise would not be able to access main because you will need to make an instance of Main first...

//        StaticTest firstInstance = new StaticTest("1st Instance");
//        System.out.println(firstInstance.getName() + " is instance number " + firstInstance.getNumInstance());
//
//        StaticTest secondInstance = new StaticTest("2nd Instance");
//        System.out.println(secondInstance.getName() + " is instance number " + secondInstance.getNumInstance());
//
//        StaticTest thirdInstance = new StaticTest("3rd Instance");
//        System.out.println(thirdInstance.getName() + " is instance number " + thirdInstance.getNumInstance());


//        int answer = multiply(6);
//        System.out.println("The answer is " + answer);
//        System.out.println("Multiplier is " + multiplier);
        // BROKEN. to fix both problems WITHOUT STATIC would need to do this.
        Main x = new Main();
        int answer = x.multiply(6);
        System.out.println("Multiplier is " + x.multiplier);    // Or could even make a constructor and use this.multiplier
    }

    public int multiply(int number) {
        return number * multiplier;
    }
}
