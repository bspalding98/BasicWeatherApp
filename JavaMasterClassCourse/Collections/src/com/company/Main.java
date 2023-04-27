package com.company;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    // Can only cast one level down. not several levels down even if still inside the level technically

    //brute-force search. Searches every element till we find what we want

    // deep copy is a an actual with it's own memory??? Not duplicated

    public static void main(String[] args) {

        Theatre theatre = new Theatre("Olympian", 8, 12);
//        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);   // shallow copy. copy but from same memory so both can change the one.
//        printList(seatCopy);
        // Even though they refer to the same object. One can be reversed in order and the other still will not be.
        // But if a record is deleted. It is deleted from both. Or same with reverse.
//        Collections.shuffle(seatCopy);
//        System.out.println("Printing seatCopy");
//        printList(seatCopy);
//        System.out.println("Printing theatre.seats");
//        printList(theatre.seats);
//
//
//        // Saying this is the highest and lowest element. Not the index
//        // Works even if they have not been sorted for min and max. has built in camperTO method is uses.
//        Theatre.Seat minSeat = Collections.min(seatCopy);
//        Theatre.Seat maxSeat = Collections.max(seatCopy);
//        System.out.println("Min seat number is " + minSeat.getSeatNumber());
//        System.out.println("Max seat number is " + maxSeat.getSeatNumber());
//
//        //SWAPPING AN ELEMENT
//
//        sortList(seatCopy);
//        System.out.println("Printed sorted seatCopy");
//        printList(seatCopy);
//
//        //Collections copy -- BARELY USED
//        List<Theatre.Seat> newList = new ArrayList<>(theatre.seats.size());
//        Collections.copy(newList, theatre.seats);
//        // THIS ERRORS
//        // Need to fit everything.
//        // Line 44 says it can contain all the objects. But atm the it has none. so for it to copy the 96 over
//        // It needs 96 already in there
//
//
////        theatre.getSeats();
        if(theatre.reserveSeat("D12")) System.out.println("Please pay for D12");
        else System.out.println("Seat already reserved");

        if(theatre.reserveSeat("D12")) System.out.println("Please pay for D12");
        else System.out.println("Seat already reserved");

        if(theatre.reserveSeat("B13")) System.out.println("Please pay for B13");
        else System.out.println("Seat already reserved");

        List<Theatre.Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);

        List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
        priceSeats.add(theatre.new Seat("B00", 13.00));
        priceSeats.add(theatre.new Seat("A00", 13.00));
        Collections.sort(priceSeats, Theatre.PRICE_ORDER);  // This is only in price order. So if you ordered by alphabet first then this. Would be correct????? stable order. So don't swap place if the same price as they don't need to be. So since
                                                            // Since it was entered in order. They are in order. Only reason why they are in alpabetical order.
        printList(priceSeats);


////        if(theatre.reserveSeat("H11")) {
////            System.out.println("Please pay");
////        } else {
////            System.out.println("Sorry, seat is taken.");
////        }
    }

    public static void printList(List<Theatre.Seat> list) {
        for(Theatre.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber() + " $" + seat.getPrice());
        }
        System.out.println();
        System.out.println("==========================================================================");
    }

    //SWAP ELEMENT STUFF - Another way to sort a list with using Collections.swap()
//    public static void sortList(List<? extends Theatre.Seat> list) {
//        for(int i = 0; i < list.size(); i ++) {
//            for(int j = (i + 1); j < list.size(); j ++ ) {
//                if(list.get(i).compareTo(list.get(j)) > 0) {
//                    Collections.swap(list, i, j);
//                }
//            }
//        }
//    }
}
