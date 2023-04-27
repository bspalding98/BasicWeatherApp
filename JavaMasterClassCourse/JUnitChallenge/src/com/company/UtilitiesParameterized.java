package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilitiesParameterized {

    private Utilities util;
    @BeforeEach
    void setup() {
        util = new Utilities();
    }


    static Collection<Object> testConditions() {
        return Arrays.asList(new Object[][] {
                // Set up parameters we want to test, followed by the expected value
                {"ABCDEF", "ABCDEFF"},
                {"AB8EFG", "AB88EFFG"},
                {"123456", "112233445566"},
                {"ZYZQB", "ZYZQQB"},
                {"A", "A"}
        });
    }

    @ParameterizedTest  // Shows it is a parameterised test
    @MethodSource("testConditions") // What source we are using for the test
    void removePairs(String expected, String actual) {
        assertEquals(expected, util.removePairs(actual));
    }
}
