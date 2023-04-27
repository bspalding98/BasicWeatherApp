package com.company;

public class Main {

    public static void main(String[] args) {

        Car porsche = new Car();        // How we define an object of type care as porsche.  then you initialise it by doing the equals and onwards.
                                        // Created an object called Porsche based of the template Car().
                                        // Make sure you initialise it. If you do not. There is an error as porsche is not initialised?
        Car holden = new Car();
//        porsche.model would only be accessible if the field in Car class was public. But not good coz it is not encapsulation.
//        Since we have it as private for encapsulation.

        System.out.println("Model is " + porsche.getModel());       // This will come up "null" because we tried printing before setting it. Null is set internal state for String.
                                                                    // Why it states null as we have not assigned this string

//        We do:
        porsche.setModel("Carrera");    // This accessed the class Car as porsche and used the method called setModel and passed in the 1 parameter needed in this case.

//        Now going to print the model
        System.out.println("Model is " + porsche.getModel());

//        Testing the validation in the setModel() method.
        porsche.setModel("911");
        System.out.println("Model is " + porsche.getModel());   // WIll be "Unknown" from the validation in the methood inside Car class.

//        Encapsulation:
//        But not allowing people to access the field directly. Like above to assign the model using the method above
//        Can really make sure data in our objects are more valid and have be validated and are correct.
    }
}
