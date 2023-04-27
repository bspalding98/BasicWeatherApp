package com.company;

public class Password {
    private static final int KEY = 748576362;
    private final int encryptedPassword;

    public Password(int password) {
        this.encryptedPassword = encryptDecrypt(password);
    }

    private int encryptDecrypt(int password) {
        int bit = password ^ KEY;   // Convert both variables into the Binary code of it. Then 1's match. You place a 1 to get a new binary code. Then when you reverse it, it equals the old one
                                    // EG. password = 10, key = 7. bit would equal 13. then 13 ^ 7 =10 or 13 ^ 10 = 7 - letMeIn() checks if the new bit values are equal.
        System.out.println(Integer.toBinaryString(bit));
        return bit;
    }

    public final void storePassword() {
        System.out.println("Saving password as " + this.encryptedPassword); // People can use this to find the password because it's public. they can extend it and change it
    }

    public boolean letMeIn(int password) {
        if(encryptDecrypt(password) == this.encryptedPassword) {
            System.out.println("Welcome");
            return true;
        }
        System.out.println("Nope, you cannot come in");
        return false;
    }
}
