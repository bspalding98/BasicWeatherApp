package com.company;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

// REMEMEBERERERERRRRRRRR
// Would normally only do one assert per method. But this is just for simplicity

// IMPORTANTTTTTTTTT
// If asserting and exception. make sure it's not in another method that already has an assert, cause it could still pass

class UtilitiesTest {

    private Utilities util;
    @BeforeEach
    void setup() {
        util = new Utilities();
    }

    @org.junit.jupiter.api.Test
    void everyNthChar() {
        // Just for normal testing
        char[] output = util.everyNthChar(new char[] {'h', 'e', 'l', 'l', 'o'}, 2);
        char[] expected = {'e', 'l'};
        // MAKE SURE it's assertArrayEquals
        assertArrayEquals(expected, output);    // Also just could put them in instead of creating variables
        // n is > length of array
        char[] word = new char[] {'h', 'e', 'l', 'l', 'o'};
        assertArrayEquals(word, util.everyNthChar(word, 9));
    }

    @org.junit.jupiter.api.Test
    void removePairs() {
        // Testing end results
        assertEquals("ABCDEF", util.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", util.removePairs("ABCCABDEEF"));
        // Testing if input is < 2 (impossible to have pairs)
        assertEquals("A", util.removePairs("A"));
        // Testing for null
        assertNull(util.removePairs(null));
    }

    @org.junit.jupiter.api.Test
    void converter() {
        assertEquals(300, util.converter(10, 5));
    }

    @org.junit.jupiter.api.Test
    void converter_two() {
        assertThrows(ArithmeticException.class, () -> { //exception is the expected - () is the lambda expression that will be everything in the code is the actual value
            util.converter(10, 0);
        });
    }

    @org.junit.jupiter.api.Test
    void nullIfOddLength() {
        assertEquals("even", util.nullIfOddLength("even"));
        assertNull(util.nullIfOddLength("odd"));
    }
}