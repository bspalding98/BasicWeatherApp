package com.company;

import java.util.ArrayList;
// Array lists automatically resize the array list pretty much.

public class GroceryList {
    private ArrayList<String> groceryList = new ArrayList<String>();

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }

    public void addGroceryItem(String item) {
        groceryList.add(item);
    }

    public void printGroceryList() {
        System.out.println("You have " + groceryList.size() + " items in your grocery list");
        for(int i = 0; i < groceryList.size(); i ++) {
            System.out.println(i + 1 + ". " + groceryList.get(i));
        }
    }

    public void modifyGroceryItem(String currentItem, String newItem) {
        int position = findItem(currentItem);
        if(position >= 0) {
            modifyGroceryItem(position, newItem);
        }
    }

    private void modifyGroceryItem(int position, String newItem) { // Made private so in main they are stating the item they want modified, not the position ( more logical) so do not give access to main (them)
        // This method only runs from in this class through another method.
        groceryList.set(position, newItem);
        System.out.println("Grocery item " + (position + 1) + " has been modified");    // If they wanted to enter in position real terms. could do -1 above and this just position then.
    }

    public void removeGroceryItem(String item) {
        int position = findItem(item);
        if(position >= 0) {
            removeGroceryItem(position);
        }
    }

    private void removeGroceryItem(int position) {  // Made private so in main they are stating the item they want removed, not the position ( more logical) so do not give access to main (them)
        // This method only runs from in this class through another method.
        groceryList.remove(position);
        System.out.println("Grocery item " + (position + 1) + " has been removed");
    }

    public boolean onFile(String searchItem) {
        int position = findItem(searchItem);
        if(position >= 0) {
            return true;
        }

        return  false;
    }

    private int findItem(String searchItem) {
        return groceryList.indexOf(searchItem);

//        int position = groceryList.indexOf(searchItem); // If there is no searchItem it returns -1 as an error (does not exist)
//        if(position >= 0) {
//            return groceryList.get(position);
//        }
//
//        return null;

//        boolean exists = groceryList.contains(searchItem); // true or false if contains it means exists pretty much
//        if(exists) {
//            int position = groceryList.indexOf(searchItem);
//            return groceryList.get(position);
//        }
//
//        return  null;

    }

}
