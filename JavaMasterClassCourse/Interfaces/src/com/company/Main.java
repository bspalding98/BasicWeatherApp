package com.company;

public class Main {

    // Interface specifies methods that a particular class that implement the interface must implement.
    // Is abstract (don't supply any code, still goes into class).
    // Interface to have common class implement the same interface

    public static void main(String[] args) {

//        ITelephone timsPhone = new DeskPhone(123456);
//        OR
        ITelephone timsPhone;
        timsPhone = new DeskPhone(123456);  // Can not instantiate using interface. Just abstract. Like a sheet that gives just rules/guidelines. Class must have interface implemented though.
        timsPhone.powerOn();
        timsPhone.callPhone(123456);
        timsPhone.answer();

        System.out.println("======================");

        timsPhone = new MobilePhone(24565);   // Could just assign to another class because they both implement the same interface and timsPhone is type interface. So that needs to match
        timsPhone.powerOn();
        timsPhone.callPhone(24565);
        timsPhone.answer();
    }
}
