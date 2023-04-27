package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//**********************
//READS NOTES DOWN BELOW
//**********************

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while(!quit) {
            System.out.println("Enter your choice:");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 0: printInstructions(); break;
                case 1: groceryList.printGroceryList(); break;
                case 2: addItem(); break;
                case 3: modifyItem(); break;
                case 4: removeItem(); break;
                case 5: searchForItem(); break;
                case 6: processArrayList(); break;
                case 7: quit = true; break;
            }
        }
        System.out.println("You have exited Grocery List App");
    }

    public static void printInstructions() {
        System.out.println("Press");
        System.out.println("\t 0 - To print option.");
        System.out.println("\t 1 - To print the list of grocery items.");
        System.out.println("\t 2 - To add an item to the list.");
        System.out.println("\t 3 - To modify an item in the list.");
        System.out.println("\t 4 - To remove an item from the list.");
        System.out.println("\t 5 - To search for an item in the list.");
        System.out.println("\t 6 - To process ArrayList.");
        System.out.println("\t 7 - To quit the application.");
    }

    public static void addItem() {
        System.out.print("Please enter the grocery item: ");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    private static void modifyItem() {
        System.out.print("Current item name: ");
        String currentItem = scanner.nextLine();
        System.out.print("Enter replacement item: ");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(currentItem, newItem);
    }

    private static void removeItem() {
        System.out.print("Enter item name to remove: ");
        String item = scanner.nextLine();
        groceryList.removeGroceryItem(item);
//        groceryList.removeGroceryItem(itemNo - 1);  // Do not want have something find the element outside of class. Should just pass and
        // the grocery list do the rest
//        REMOVING ALL THESE THINGS LEAVE THE COMPLEXITY to the class.
//        WE DO NOT want to know all the workings about it. All we want to do it pass in items to change and remove.
//        dont want someone to have to enter what position they want to change. They just should need to enter the name of the item and we do the rest.
    }

    private static void searchForItem() {
            System.out.print("Item to search for: ");
            String searchItem = scanner.nextLine();
            if(groceryList.onFile(searchItem)) {
                System.out.println("Found " + searchItem + " in our grocery list");
            } else {
                System.out.println(searchItem + " is not in the shopping list");
            }
    }

    public static void processArrayList() {
        ArrayList<String> newArray = new ArrayList<String>();
        newArray.addAll(groceryList.getGroceryList());  // copying arraylist

        ArrayList<String> nextArray = new ArrayList<String>(groceryList.getGroceryList());  // copying arraylist

        String[] myArray = new String[groceryList.getGroceryList().size()];
        myArray = groceryList.getGroceryList().toArray(myArray);    // Turning arraylist into an array


        System.out.println(newArray);
        System.out.println(Arrays.toString(myArray));
    }
}
