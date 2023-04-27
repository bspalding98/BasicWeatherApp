package com.company;

// This now gives you the password because we were able to override the storePassword method as it was public.
// make the storePassword() method. So this way it cannot be overwritten.

public class ExtendedPassword extends Password {
    private int decryptedPassword;

    public ExtendedPassword(int password) {
        super(password);
        this.decryptedPassword = password;
    }

//    @Override
//    public void storePassword() {   // No cannot be overridden because method is final.
//        System.out.println("Saving password as " + this.decryptedPassword);
//    }
}
