package com.company;

import java.awt.datatransfer.FlavorEvent;
import java.awt.datatransfer.FlavorListener;
import java.util.HashMap;
import java.util.Map;

public class MapProgram {
    // MAP is not a true collection even though it is in the collections setting sorta. map is like a lang dictionary. Words is key and the values being a definition.
    // Map is like dictionary in python I think.
    // Cannot contain duplicate keys and the keys can only contain 1 value.

    // Values can be overwritten just but using put and the same key again.
    // Map cannot contain itself as a key

    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();      // String, String is the key and the value and we used String because of using generics.

        // Determine to only add a key if it is not there
        if(languages.containsKey("Java")) {
            System.out.println("Java already exists");
        } else {
            languages.put("Java", "a compiled high level, object-oriented, platform independent language");
            System.out.println("Java added successfully");
        }

        languages.put("Python", "an interpreted, object-orientated, high-level programming langauge with dynamic symantics");
        languages.put("Algol", "an algorithmic language");

        // Can check if this is the first reference to the key by doing this below. it prints null if it's a brand new key-value pair added to the dictionary.
        System.out.println(languages.put("BASIC", "Beginners All Pupose Symbolic Instruction Code"));
        System.out.println(languages.put("Lisp", "Therein lies madness"));

//        System.out.println(languages.get("Java"));
//        System.out.println(languages.put("Java", "this course is about Java"));     // This prints the value added to prior then being edited first, then the value is updated.
        System.out.println(languages.get("Java"));      // Line will print the value above now.

        // Determine to only add a key if it is not there
        if(languages.containsKey("Java")) {
            System.out.println("Java is already in the map");
        } else {
            languages.put("Java", "this course is about Java");
            System.out.println("Java added successfully");
        }

        // print out values by looping with the keySet() - will print out keys and values
        // With a hashmap there is no particular order, even from the order of them being added.
        System.out.println("================================================================");

        for(String key : languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));       // keyset() gets the keys, so the variabel key is being assigned jsut the key itself. So then get(key) gets the value of the that key
        }

        //Remove a key from a map
//        languages.remove("Lisp");
        // OR -> Removes if both key and value matches
        if(languages.remove("Algol", "a family of algorithmic languages")) System.out.println("Algol removed"); // Returns true of false this method -> Needs to be key and value thought I think?
        else System.out.println("Algol not removed, key/value pair not found.");
        System.out.println("================================================================");

        // Replace method. Use to replace the entry for the specified key if it's already mapped to a value. So replace value of the key if the key exists.
        System.out.println(languages.replace("Lisp", "a functional programming language with imperative features"));    // Still return entry before updating. So return previous entry
        System.out.println(languages.replace("Scala", "This will not be added"));   // Return null because the key does not exists. and also was not added to the map.



        System.out.println("================================================================");
        // replace method again but this time comparing the value. If this was the old value, change it to the new one. Not comparing key now, comparing value.
        if(languages.replace("Lisp", "This will not work", "a functional programming language with imperative features")) {
            System.out.println("Lisp replace");
        } else {
            System.out.println("This was not replaced.");
        }


        for(String key : languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }
    }

}
