package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");
    // Four types of NESTED classes
        // Static - used to associate a class with its outer class.
        // Nonstatic (inners class)
        // local (inners class defined inside a scope block)
        // anonymous (nested class without a class name)

//    local classes are declared inside a block like if statements.
//    anonymous class is also a local class but has no name. and has to be declare and instantiated at the same time as it has no name
//    Used when a local class is required only once. THIS IS VERY CLASS> like attaching event handles to button in a user interface
//      If you had several button, each would required different onclick methods. So a local might not be good. EG> one to print something and another to quit.
    public static void main(String[] args) {
            //USING LOCAL CLASS
//        class ClickListener implements Button.OnClickListener { // Local class. Not used much but makes sense here coz it is not used anywhere else.
//            public ClickListener() {
//                System.out.println("I've been attached");
//            }
//
//            @Override
//            public void onClick(String title) {
//                System.out.println(title + " was clicked");
//            }
//        }
//        btnPrint.setOnClickListener(new ClickListener());
//        listen();

          //USING ANONYMOUS CLASS
        btnPrint.setOnClickListener(new Button.OnClickListener() {      // Easier way to make a button
            @Override
            public void onClick(String title) {
                System.out.println("Title was clicked.");
            }
        });
        listen();
        System.out.println("YO");
        listen();


        //USING INNER CLASS
//        Gearbox mcLaren = new Gearbox(6);
////        Gearbox.Gear first = mcLaren.new Gear(1, 12.3); //mcLaren essentially means Gearbox.Gear but you cannot do that as you need a Gearbox to create a gear. You cannot create a gear if you don't have an instance of a gear.
////        System.out.println(first.driveSpeed(1000));
//
////        ABOVE is not good as before we had gear public and was allowing program to access the inner class and we don't want that.
//        // NOW WITH GEAR PRIVATE everything should be accessed through Gearbox.
////        mcLaren.addGear(1, 5.3);
////        mcLaren.addGear(2, 10.6);             // No longer needed as we created gears in constructor
////        mcLaren.addGear(3, 15.9);
//        mcLaren.operateClutch(true);
//        mcLaren.changeGear(1);
//        mcLaren.operateClutch(false);
//        System.out.println(mcLaren.wheelSpeed(1000));
//        mcLaren.changeGear(2);
//        System.out.println(mcLaren.wheelSpeed(3000));
//        mcLaren.operateClutch(true);
//        mcLaren.changeGear(3);
//        mcLaren.operateClutch(false);
//        System.out.println(mcLaren.wheelSpeed(6000));
    }

    private static void listen() {
        boolean quit = false;
        while(!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 0: quit = true; break;
                case 1: btnPrint.onClick();
            }
        }
    }
}
