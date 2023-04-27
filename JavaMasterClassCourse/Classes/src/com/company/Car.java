package com.company;

import java.util.Locale;

public class Car {

    // State components, characteristics of the car
    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String colour;

//    No we create an object from this car(class) as this is just a template(blueprint) -- In main. Top section
//    private means you do not want to allow a class outside of the Car class to access these variables. So public would allow that.

//    How to give access to these fields for other classes
//    Done through a method by allowing the method to update the model


//    This is a setter
    public void setModel(String model) {         // Not static because we want it to have access to all objects that are created with the class I think?
//        this.model = model;     // This is because you have a parameter and field of the same name. So to distinguish use "this" for fields.
                                // THe line means update the field model with the parameter model.

//        Can do validation as well with Setter is another reason why it is good
        String validModel = model.toLowerCase();    //Making the String parameter all lowercase to compare
        if(validModel.equals("carrera") || validModel.equals("commodore")) {    // Comparing
            this.model = model;
        } else {
            this.model = "Unknown";     // Still need to use "this.model" to make the field equal the parameter passed in. So then it can still be accessed with getter methods
        }
    }

//    Now we are making a getter to print the data retrieved.
    public String getModel() {
        return this.model;
    }



}
