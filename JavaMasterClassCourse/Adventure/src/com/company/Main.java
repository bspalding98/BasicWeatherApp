package com.company;

import java.util.*;

public class Main {
    private static final Map<Integer, Location> locations = new HashMap<>();  // Making the object that stores multiple locations
    private static final List<String> directions = new ArrayList<>(Arrays.asList("WEST", "NORTH", "EAST", "SOUTH", "QUIT"));


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new Location(2, "You are  at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));

        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);

        locations.get(2).addExit("N", 5);

        locations.get(3).addExit("W", 1);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);


        int loc = 1;
        while(true) {
            System.out.println(locations.get(loc).getDescription());
            if(loc == 0) break;

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are: ");
            for(String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            // He used hashmaps here with the key being the word and value being the letter and did (variableName).containsKey(word)
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
