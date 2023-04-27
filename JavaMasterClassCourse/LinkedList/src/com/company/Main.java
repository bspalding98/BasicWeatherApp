package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {
//    Each integer needs 4 bytes to store the memory. So each address goes up in 4 bytes
//    Formula is 100 + (index * 4) - index 0 starts at 100. Hence why you have 100 there. so index 3 would be 100 + (3 * 4) which is 112

//    Double uses 8 bytes so would multiply by 8 instead.
//    They will always consume this many bytes regardless on value size.

//    Strings just list the string address and the memory is saved with a string address and are linked together. Would just print in index order not string address order
//    String address is just used to find the string, not organise it in the right order.
//    String address also does not need to be set. Can be 1000 and then 4023.


//    Linked list alternative to ArrayList.
//    Stores the actual link to the next item in the list as well as the data.
//    essentially each element is assigned a link and data. not just data.
//    What the strings use with the string address not being in order and not consistent.

//    With arrayList if you want to add something you need to move everything down which can use a lot of processing power for big records.
//    So with LINKEDLIST it essentially just removes the path(link) from index 0 and 1 and then creates a new link which would be 0  1 2
//    EG. LINKEDLIST is Sydney which points to melbourne. Want to add alice springs inside it.
//    Sydney points to alice springs now and then alice springs point to melbourne.
//    So set alice sprins to point it to where sydney use to point to. THen set sydney to point to alice springs.
//    So now if you wanted to remove alice springs. Just change sydney to point to where alice springs was to
//    Alice Springs would then just be automatically destroyed to java because nothing is point to it during its java collection




    public static void main(String[] args) {

        Customer customer = new Customer("Tim", 54.96);
        Customer anotherCustomer;
        anotherCustomer = customer;     // Assigning second class to same memory. So two classes to same memory address
        anotherCustomer.setBalance(12.18);  // Updated memory which then updates both classes as they are saved to the same memory.
        System.out.println("Balance for customer " + customer.getName() + " is " + customer.getBalance());


        ArrayList<Integer> intList = new ArrayList<Integer>();

        intList.add(1);
        intList.add(3);
        intList.add(4);

        for(int i = 0; i < intList.size(); i ++) {  // 1, 3, 4
            System.out.println(i + ": " + intList.get(i));
        }

        intList.add(1, 2);

        for(int i = 0; i < intList.size(); i ++) {     // 1, 2, 3, 4 - They are auto moved down. Can be a lot of processing when you have hundreds of records. Same with removing.
            System.out.println(i + ": " + intList.get(i));
        }

    }
}
