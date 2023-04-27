package com.company;

public class Main {
    // Cannot have a private class because then nothing can access the class as it is the top level...
    // TOP LEVEL INCLUDES:
    // Classes, Interfaces, Enums

    // ACCESS MODIFIERS (Top level):
    // Private: Cannot have private modifiers at the top level
    // Public:
        // The object is visible to all classes everywhere, whether they are in the same package or have imported the package containing the public class
    // Package-private:
        // Object is only available within its own package (and is visible to every class within the package).
        // You specific this by not specifying the classes. It have no keyword as it is the default.

    // Member Level:
    // Public:
        // Has the same meaning at the member level. public class, member (or field) and public method can be accessed from any other class anywhere, even
        // in a different package.
    //Package-Private:
        // Also has the same meaning. Object with no modifier is visible to all classes within the package.
    //Private:
        // The object is only visible within the class it is declared. It is not visible anywhere else (including in subclasses of its class).
    //Protected:
        // Object is visible anywhere in the package like package-private. But also in subclasses even is they are in another package.

    public static void main(String[] args) {

        Account timsAccount = new Account("Tim");
        timsAccount.deposit(1000);
        timsAccount.withdrawal(500);
        timsAccount.withdrawal(-200);   // Should error
        timsAccount.deposit(-20);       // should error
        timsAccount.calculateBalance();

//        timsAccount.balance = 5000; // Bank would pick it up as fraud because no transaction history of it. But since that is public as well can change it here too
//        timsAccount.transactions.add(4500);
        timsAccount.calculateBalance();

    }
}
