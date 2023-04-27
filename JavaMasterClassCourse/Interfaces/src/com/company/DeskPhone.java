package com.company;

public class DeskPhone implements ITelephone {  // Remember all methods must be implemented. In order for DeskPhone to be a valid Telephone class all the methods in ITelephone must be implemented.
    // If you did not say want DeskPhone to have a powerOn() you still need to override them all, but could have a message print error this is not supported. Simple fix.

    private int myNumber;
    private boolean isRinging;

    public DeskPhone(int myNumber) {
        this.myNumber = myNumber;
    }

    @Override
    public void powerOn() {
        System.out.println("No action taken, desk phone does not have a power button");
    }

    @Override
    public void dial(int phoneNumber) {
        System.out.println("Now ringing " + phoneNumber + " on deskphone");
    }

    @Override
    public void answer() {
        if(isRinging) {
            System.out.println("Answering the desk phone");
            isRinging = false;
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if(phoneNumber == myNumber) {
            System.out.println("Ring ring");
            return (isRinging = true);
        }
        return false;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }
}
