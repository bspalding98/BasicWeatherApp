package com.company;

// parameterized tests
// Want every test fresh - but can duplicate code. so use parameterised tests

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountParameterized {

    private BankAccount account;
    private double amount;
    private boolean branch;
    private double expected;


    @BeforeEach
    void setup() {
        account = new BankAccount("Boyd", "Spalding", 1000, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }


    //The two sets of square brackets signify a two-dimensional array of objects, all of type Object.
    //Each element of the array is also an array; e.g., {100.00, true, 1100.00} is an array of objects.
    // Collectively, those arrays are elements of another array, which is then returned as a List through the Arrays.asList() method call

    // So element one is not just a value. it's an array of {100, true, 1100} to pass in all those values
    // So when getBalance_deposit() is run. It runs through each element in the 1st array. And each element
    // holds and array which is the 2nd one and it holds all the parameters needed for the testing
    // Hence the 2D array
    static Collection<Object> testConditions() {
        return Arrays.asList(new Object[][] {
                // Set up parameters we want to test, followed by the expected value
                {100, true, 1100},
                {200, true, 1200},
                {325.14, true, 1325.14},
                {489.33, true, 1489.33},
                {1000, true, 2000}
        });
    }
    // ANOTHER WAY TO WRITE THIS
//    static Stream<Arguments> testConditions() {
//        return Stream.of(
//                Arguments.arguments(100.00, true, 1100.00),
//                Arguments.arguments(200.00, true, 1200.00),
//                Arguments.arguments(325.14, true, 1325.14),
//                Arguments.arguments(489.33, true, 1489.33),
//                Arguments.arguments(1000.00, true, 2000.00)
//        );
//    }

    @ParameterizedTest  // Shows it is a parameterised test
    @MethodSource("testConditions") // What source we are using for the test
    void getBalance_deposit(double amount, boolean branch, double expected) {
        account.deposit(200, true);
        assertEquals(1200, account.getBalance());
    }
}
