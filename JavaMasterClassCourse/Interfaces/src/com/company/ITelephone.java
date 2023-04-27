package com.company;

public interface ITelephone {
    // We just define the methods that are going to be used in this interface.
    // That if a class uses this interface must use all these methods.

    // Code still goes into the class remember, this is just to showcase what the methods must be
    // Private or Public is useless because you will putting the access modifier in the class so could be either.
     void powerOn();
     void dial(int phoneNumber);
    public void answer();
    public boolean callPhone(int phoneNumber);
    public boolean isRinging();
}
