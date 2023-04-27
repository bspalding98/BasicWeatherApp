package com.company;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class Utilities {

    // returns a char array containing every nth char. When
    // sourceArray.length < n, returns sourceArray
    public char[] everyNthChar(char[] sourceArray, int n) {

        if(sourceArray == null || sourceArray.length < n) return sourceArray;

        int returnedLength = sourceArray.length / n;
        char[] result = new char[returnedLength];   // that many chars or does that just equal one char as that? Can't remember
        int index = 0;

        for(int i=n-1; i < sourceArray.length; i += n) result[index++] = sourceArray[i];   // starts at index one?

        return result;
    }

    // Removes pairs of the same character that are next
    // to each other, by removing one occurrence of the character
    // "ABBCDEEF" -> "ABCDEF"
    // "ABCBDEEF" -> "ABCBDEF" (The two B's aren't next to each other, so they aren't removed. - Has to be same to the right of it
    // (last char will always not be a pair even if on before is the same)
    public String removePairs(String source) {
        //If length is less than 2, there won't be any pairs
        if(source == null || source.length() < 2) return source;

        StringBuilder sb = new StringBuilder();
        char[] string = source.toCharArray();

        for(int i=0; i < string.length -1; i++) {  // need - 1 because we are checking 1 index after so this ensure we don't go out of range
            if(string[i] != string[i + 1]) {  // If we do [i++] it will plus i instead of 1. so it is skipping
                sb.append(string[i]);
            }
        }
        sb.append(string[string.length-1]); // End one is always added because has no pair to the right?

        // Can also do the above but compare the previous element. THis way you get no out of bounds exception to cater for and also just auto append first element
        // instead of last one

        // Also add catch for indexout of bounds where you just add the last element then

//        for (int i = 0; i < string.length; i++) {
//            try {
//                if (string[i] != string[i+1]) {
//                    sb.append(string[i]);
//                }
//            } catch (IndexOutOfBoundsException e) {
//                sb.append(string[i]);
//            }
//        }



        // ANOTHER WAY with iterators

        // char[] string = source.toCharArray(); // <- no longer needed

//        CharacterIterator iterator = new StringCharacterIterator(source);
//
//        while (iterator.current() != CharacterIterator.DONE)  // DONE means that it's empty so out of bounds essentially but won't error or anything
//        {
//            char currentChar = iterator.current(); // getting current char
//            char nextChar = iterator.next(); // getting next char and updating current's position --- This also won't error when out of bands. Perks of iterator
//            if (currentChar != nextChar)
//                sb.append(currentChar);
//        }
//
        return sb.toString();
    }

    //perform a conversion based on some internal business rule
    public int converter(int a, int b) {
        return (a/b) + (a * 30) -2;
    }

    public String nullIfOddLength(String source) {
        if(source.length() % 2 ==0 ) return source;
        return null;
    }
}
