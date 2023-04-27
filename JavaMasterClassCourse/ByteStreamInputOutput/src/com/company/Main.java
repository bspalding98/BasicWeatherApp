package com.company;

import java.util.*;

public class Main {
    private static Locations locations = new Locations();
    private static final List<String> directions = new ArrayList<>(Arrays.asList("WEST", "NORTH", "EAST", "SOUTH", "QUIT"));


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
    }
}
