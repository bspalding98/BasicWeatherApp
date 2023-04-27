import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {
//    fields
    private ArrayList<String> contactNames = new ArrayList<String>();
    private ArrayList<String> contactNumbers = new ArrayList<String>();
    private Contacts contacts;
    private Scanner s = new Scanner(System.in);

//    Print Contacts
    public void printContacts() {
        System.out.println("You have " + contactNames.size() + " contacts in your mobile.");
        for(int i = 0; i < contactNames.size(); i ++) {
            System.out.println("Name: " + contactNames.get(i) + "\n\tNumber: " + contactNumbers.get(i));
        }
    }


//    Add Contacts
    public void addContact(String contactName) {
        int index = findContact(contactName);
        if(index >= 0) {
            System.out.println("Sorry this contact " + contactName + " already exists.");
        } else {
            System.out.print("Enter contact number: ");
            String contactNumber = s.nextLine();
            addContact(contactName, contactNumber);
        }
    }

    private void addContact(String contactName, String contactNumber) {
        contactNames.add(contactName);
        contactNumbers.add(contactNumber);
    }


//    Modify Contacts
    public void modifyContact(String currentContactName, String contactName) {  // This does not need to be nested. Can have if as the else and else if as nested
        int index = findContact(currentContactName);
        if(index >= 0) {

            int duplicate = findContact(contactName);
            if(duplicate >= 0) {
                System.out.println("Sorry this contact " + contactName + " already exists.");
            } else {
                System.out.print("Enter contact number: ");
                String contactNumber = s.nextLine();
                modifyContact(index, contactName, contactNumber);
            }
        }
        else {
            System.out.println("Contact name " + currentContactName + " does not exist in your contacts.");
        }
    }

    private void modifyContact(int index, String contactName, String contactNumber) {
        contactNames.set(index, contactName);
        contactNumbers.set(index, contactNumber);
    }


//    Remove Contacts
    public void removeContact(String contactName) {
        int index = findContact(contactName);
        if(index >= 0) {
            removeContact(index);
        } else {
            System.out.println("Contact name " + contactName + " does not exist in your contacts.");
        }
    }

    private void removeContact(int index) { // Private from main.
        contactNames.remove(index);
        contactNumbers.remove(index);
    }


//    Check for existing contact name
    public int findContact(String contactName) {
        return contactNames.indexOf(contactName);
    }

    public boolean searchForContact(String contactName) {
        int position = findContact(contactName);
        return position >= 0;
    }
}
