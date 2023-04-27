package com.company;

import java.util.*;

//Input is reading data from a source
    //Output involves writing it to a destination
        // source or destination are normally files or diskdrives. but can be databases or even keyboard (reading from system.in)
    // disk files and directories
        // Normally want new directory to store data or to present the user with a list of files to choose from. File allows this.

    //IO can be performed using Char or Byte data - only classes vary
    // reading and writing char data. in a readable format and can you open the resulting files in a txt editor
    // binary revolves writing bytes
        // What you should use, depends on what the data represents

    // serial/sequential or random access files
        // serial is a stream of data that arrives at your program or sent out of it that arrives in defined order with each piece of data follow sequence
        //random access - only really applies to files. Allows to jump around and access, retrieve and overwrite any parts of the files you choose
            // Used for say a database. Can find the data without having to go through thousands of bits of data to find it everytime. normally and index showing where it is in the database


public class Main {
    private static Locations locations = new Locations();
    private static final List<String> directions = new ArrayList<>(Arrays.asList("WEST", "NORTH", "EAST", "SOUTH", "QUIT"));


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int loc = 1;
//        int loc = 132;
        while(true) {
            System.out.println(locations.get(loc).getDescription());
            if(loc == 0) break;

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are: ");
            for(String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            String[] words = direction.split(" ");
            int tempLoc = loc;
            for(String word : words) {
                if(directions.contains(word) || exits.containsKey(word)) {
                    String[] letter = word.split("");
                    if(exits.containsKey(letter[0])) loc = exits.get(letter[0]);
                }
            }
            if(tempLoc == loc) System.out.println("You cannot go in that direction");
        }

//        String[] road = "You are standing at the end of a road before a small brick building".split(" ");
//        for(String i : road) System.out.println(i);
//
//
//        System.out.println("============================================");
//
//        String [] building = "You are inside a building, a well house for a small spring".split(", ");
//        for(String i : building) System.out.println(i);
    }
}
