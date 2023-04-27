package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
//        Create a LinkedList of the places we want to visit which is the capitals of Australia.
        LinkedList<String> placesToVisit = new LinkedList<String>();
        addInOrder(placesToVisit, "Sydney");
        addInOrder(placesToVisit, "Melbourne");
        addInOrder(placesToVisit, "Brisbane");
        addInOrder(placesToVisit, "Perth");
        addInOrder(placesToVisit, "Canberra");
        addInOrder(placesToVisit, "Adelaide");
        addInOrder(placesToVisit, "Darwin");
        printList(placesToVisit);

        addInOrder(placesToVisit, "Alice Springs");
        addInOrder(placesToVisit, "Darwin");        // This catch message prints first as it prints in alphabetical order
        printList(placesToVisit);

        visit(placesToVisit);
//        placesToVisit.add("Sydney");
//        placesToVisit.add("melbourne");
//        placesToVisit.add("Brisbane");
//        placesToVisit.add("Perth");
//        placesToVisit.add("Canberra");
//        placesToVisit.add("Adelaide");
//        placesToVisit.add("Darwin");

//        printList(placesToVisit);
//
//        placesToVisit.add(1, "Alice Springs");      // This takes a lot less processing power than the ArrayList as it just makes a detour. It does not move everything down.
//        printList(placesToVisit);
//
//        placesToVisit.remove(4);
//        printList(placesToVisit);

//        Advantages of the LinkedList:
//        Impose an order to alphabetically order the LinkedList even when records are added.
//        Using a list iterator() method below inOrder()


    }

    private static void printList(LinkedList<String> linkedList) {
//        Iterator is another way of accessing and going through all entries going through an array or particular collection.
//        Iterator<String> i = linkedList.iterator();
        //        while(i.hasNext()) {
//            System.out.println("Now visitng " + i.next());
//        }
//        System.out.println("=========================");


        for (String s : linkedList) {       // Better way for for loops in general. Java builts already realise linkedList is a LintList<String> so there is no need to restate that and I guess the iterator() is built into it so it auto knows to do this for a for loop
            System.out.println("Now visitng " + s);
        }
        System.out.println("=======================");
    }

    private static boolean addInOrder(LinkedList<String> LinkedList, String newCity) {
//        GOing to make a list iterator. more flexibility
        ListIterator<String> stringListIterator = LinkedList.listIterator();        // When you create this for the first time. It goes to the start(before first entry)
        // The statement above does not automatically point to the first record. So the .next() points to the first not the second which is why i was confused.

        while(stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);      // means: stringListIterator.next() = next index/value/link so when we can use .compareTO() in order to compare the current one to the next one.
            // GIve us a numbers. If the number is 0, it means they match
            // .next() is used because the while loop is not iterating. So we need to iterate it.

            if(comparison == 0) {
                // equal, do not add
                System.out.println(newCity + " is already included as a destination");
                return false;
            }else if(comparison > 0) {
                // new City should appear before this one
                // Brisbane -> Adelaide
                // Need to go back as above we did .next() and went to the next one
                stringListIterator.previous();  // Goes back to the Brisbane record from the Adelaide record
                stringListIterator.add(newCity);    // Will now add it in the right position. LIST ITERATOR THE ONLY ONE THAT CAN DO .previous()
                return true;
            } else if(comparison < 0) {
                //move onto next city.
            }
        }

        stringListIterator.add(newCity);    // If we get here it means we went through the whole while loop and did find a suitable place to put it. So that means it is at the end
        // We also put this statement here and not in the last else statement because when we check the first one and there is no records. THe while loop will not run
        // As it checks if it has another entry.
        return true;
    }

    private static void visit(LinkedList cities) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();

        if(cities.isEmpty()) {
            System.out.println("No cities in the itinerary");
        } else {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }

        while(!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action) {
                case 0:
                    System.out.println("Holiday (Vacation) over");
                    quit = true;
                    break;
                case 1:
                    if(!goingForward) {     // element cursor position sits between record and next. so need this for buffer when back and forwards to adjust it.
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now visiting " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list");
                        goingForward = false;   // Changes the direction as at the end so cannot go forward.
                    }
                    break;
                case 2:
                    if(goingForward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now visiting " + listIterator.previous());
                    } else {
                        System.out.println("We are at the start of the list");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress ");
        System.out.println("0 - to quit\n" +
                "1 - go to next city\n" +
                "2 - go to previous city" +
                "3 - print menu options");
    }
}
