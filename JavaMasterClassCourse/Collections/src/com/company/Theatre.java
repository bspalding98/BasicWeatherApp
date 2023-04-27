package com.company;

import java.util.*;


public class Theatre {
    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();


// CAN have several of these. So could sort by price and then another to sort by name. CompareTo can also do that by checking first, if they same check second.
    // Can split and declare if click comparator and then bulb...
// PROBLEM WITH COMPARATOR
    // phrase "and ordering being consistent with equals" Not always equals because the price is. But not the seat. So do what is said above to fix that really easily.
    static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() {
        @Override
        public int compare(Seat seat1, Seat seat2) {
            if(seat1.getPrice() < seat2.getPrice()) return -1;
            else if(seat1.getPrice() > seat2.getPrice()) return 1;
            else return 0;
        }
    };

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows - 1);  // Think -1 because in the for loop it is used and will run over with 0 index if not -1 even though it is a char???
        for(char row = 'A'; row <= lastRow; row ++) {
            for(int seatNum = 1; seatNum <= seatsPerRow; seatNum ++) {
                double price = 12.00;   // Base price for seats.
                if((row < 'D') && (seatNum >= 4 && seatNum <= 9)) price = 14.00;        // Increase price because sitting at the front half and in the middle
                else if((row > 'F') || (seatNum < 4 || seatNum > 9)) price = 7.00;     // Discount for back rows or edge seat
                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    // Brute force search at the moment - new code. binarySearch is fastest way to find an item in a sorted list.
        // Checks element in mid point of list and plays higher or lower. and keeps repeating, reducing half each time. so no more than 10 checks 2 ^ 10 1024.
        // 1.48mil can be found in no more than 20 comparisons. ONLY IF SORTED
    //This originally took over 100 loops to find it as its 8 rows of 12 and H11 is towards the end.
    // New way it only took 7 loops...
    public boolean reserveSeat(String seatNumber) {
//        Seat requestSeat = null;
        Seat requestedSeat = new Seat(seatNumber, 0);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null); // Using compareTO operator here. // Think null means to use inbuilt compare operator? The one below JAVA defualt one?
        if(foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        }
        System.out.println("There is no seat " + seatNumber);
        return false;

//        for(Seat seat : seats) {
//            System.out.print(".");
//            if(seat.getSeatNumber().equals(seatNumber)) {
//                requestSeat = seat;
//                break;
//            }
//        }
//        if(requestSeat == null) {
//            System.out.println("There is no seat " + seatNumber);
//            return false;
//        }
//        return requestSeat.reserve();
    }

    // for testing
    public Collection<Seat> getSeats() {
        return seats;
    }



    public class Seat implements Comparable<Seat>{
        private final String seatNumber;
        private double price;
        private boolean reserved = false;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());   // Think this gets passed into Collections class and they do it themselves.
        }

        public boolean reserve() {
            if(!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + this.seatNumber + " reserved");
                return true;
            }
            return false;
        }


        public boolean cancel() {
            if(this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + this.seatNumber + " cancelled");
                return true;
            }
            return false;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public double getPrice() {
            return price;
        }
    }
}
