import java.util.Scanner;

public class Main {
    public static Scanner s = new Scanner(System.in);
    private static MobilePhone contacts = new MobilePhone();


    public static void main(String[] args) {
        System.out.println("Welcome to your contacts");
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while(!quit) {
            System.out.println("Enter your choice:");
            choice = s.nextInt();
            s.nextLine();

            switch(choice) {
                case 0: printInstructions(); break;
                case 1: contacts.printContacts(); break;
                case 2: addContact(); break;
                case 3: modifyContact(); break;
                case 4: removeContact(); break;
                case 5: searchForContact(); break;
                case 6: quit = true; break;
            }
        }
        System.out.println("You have exited your contacts");
    }

    public static void printInstructions() {
        System.out.println("Press");
        System.out.println("\t 0 - To print options.");
        System.out.println("\t 1 - To print the list of contact.");
        System.out.println("\t 2 - To add a new contact.");
        System.out.println("\t 3 - To modify an existing contact.");
        System.out.println("\t 4 - To remove an existing contact.");
        System.out.println("\t 5 - To search for a contact.");
        System.out.println("\t 6 - To quit the application.");
    }

    public static void addContact() {
        System.out.print("Enter new contact name to add: ");
        contacts.addContact(s.nextLine());
    }

    public static void modifyContact() {
        System.out.print("Enter existing contact name to modify: ");
        String currentName = s.nextLine();
        System.out.print("Enter new contact name: ");
        String currentNumber = s.nextLine();
        contacts.modifyContact(currentName, currentNumber);
    }

    public static void removeContact() {
        System.out.print("Enter existing contact name to remove: ");
        contacts.removeContact(s.nextLine());
    }

    public static void searchForContact() {
        System.out.print("Contact to search for: ");
        String contactName = s.nextLine();
        if(contacts.searchForContact(contactName)) {
            System.out.println("Found " + contactName + " in our contacts");
        } else {
            System.out.println(contactName + " is not in our contacts");
        }
    }
}
