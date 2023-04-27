package com.company;

// Unit is typically a method
    // Unit test will typically test one method


// He is using Junit4 and his has throws Exception in all of his methods automatically. Should I be adding that???

// Make sure to add in fail() when have no code in them
    // This is because the code block will be stubs otherwise (empty) and always pass because they don't assert anything

// When tests fail throws assertion errors
// Junit tests the output of the method against the assertion we made about the expected output
// Test fails if the assertions is not met

// Can add a test method at anytime
// Don't have to match a test method to a method in the class we are testing
// must be annotated with @org.junit.jupiter.api.Test and also be void and public


// you put in the method assertions on what you expect should happen.
// If it is met, the test passes. If not met, it fails


// Every test method should be self contained. What happens in one test method shouldn't depend on what happened in another test method
    // Should start fresh and be able to run independently
// However you might need to create a instance of a class that will be used for all methods..???

// Even though can add multiple asserts to a test method. Not good practice to do so.
    // The best practice is one test per test condition or assertion

// Test method names should give some indication of the actual condition their testing

// Looking at a test suite - the classes results (so all tests) or a method with multiple assertions
    // Might be good to add messages to make it easier to see what's going on
// Sometime failed tests results might be saved to a file, so easier with message to read and understand where the error is and the changes needed to be changed

// Other assert methods
    // assertNotEquals() - When we don't want an actual value to equal a specific value
    // assertArrayEquals() - Verify the value of an array - assertEquals() won't work because it will need to be the same instance
    // assertNull()
    // assertNotNull()
    // assertTrue()
    // assertFalse()

// Checking whether two instances are the exact same instance - checks reference - could be different instance pointing to same reference in memory
    // assertSame()
    // assertNotSame()


    // assertThat() compares the actual value against a matcher (Junit matcher class)
        // More powerful than the other assert methods, since we can compare the actual value against a range of values.


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {


    private BankAccount account;
    private static int count;

    // executes once before anything else in the class. Maybe want to open a file or something
    // This may not print in order, but still works
    @BeforeAll
    static void beforeClass() {
        System.out.println("This executes before any test cases. Count = " + count++);
    }

    // Makes this run before each test (not including @BeforeALl) - could also just initialise it when you create the account variable instead???
    @BeforeEach
    void setup() {
        account = new BankAccount("Boyd", "Spalding", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }


    @org.junit.jupiter.api.Test
    void deposit() {
        double balance = account.deposit(200.00, true);
        assertEquals(1200.00, balance, 0);  // Third para delta - allows leeway in comparison. So as long as difference is within the delta range. eg. double could be sometime 1199.9999 so delta can fix it
    }

    @org.junit.jupiter.api.Test
    void withdraw_branch() {
        double balance = account.withdraw(600, true);
        assertEquals(400.00, balance, 0);
    }

    @org.junit.jupiter.api.Test
    void withdraw_notBranch() {
        // expecting exception to be thrown as seen in BankAccount - so this is catering for it to still pass test if it's thrown
        // So now if code inside doesn't make it throw an exception it won't pass
//        assertThrows(IllegalArgumentException.class, () -> {
//            double balance = account.withdraw(600, false);
//            assertEquals(400, balance, 0);
//        });

        // Since want it to throw an exception, only need to write the part that should throw the exception
        // () is a method and what is inside that wants to be run? Lambda expression?
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(600, false);
            fail("Should have thrown an IllegalArgumentException"); // Stating it shouldn't have made it here
        });

        // Versions before Junit 4 you had to have a try {} as shown below
//        try {
//            account.withdraw(600, false);
//            fail("Should have thrown an IllegalArgumentException");
//        } catch(IllegalArgumentException e ) {
//
//        }
    }

    @org.junit.jupiter.api.Test
    void getBalance_deposit() {
        account.deposit(200, true);
        assertEquals(1200, account.getBalance(), 0);
    }


    @org.junit.jupiter.api.Test
    void getBalance_withdraw() {
        account.withdraw(200, true);
        assertEquals(800, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    public void isChecking_true() {
        assertTrue(account.isChecking(), "The account is NOT a checking account");   // pass if true and not pass if false
    }

    // Runs once after class has run through everything
    @AfterAll
    static void afterClass() {
        System.out.println("This executes after any test cases. Count = " + count++);
    }

    // runs after each method other than @AfterAll
    @AfterEach
    void teardown() {
        System.out.println("Count = " + count++);
    }


//    @org.junit.jupiter.api.Test
//    void dummyTest() {
//        // first para is the value we expect and the 2nd para is the value we want to test or the actual value
//        assertEquals(20, 21);
//    }
}

















