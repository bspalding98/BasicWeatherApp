package sample.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class ContactData {

    private static final ContactData instance = new ContactData();
    private static final String filename = "Contacts.txt";
    
    private ObservableList<Contact> contacts;



    public ContactData() { contacts = FXCollections.observableArrayList(); }
    
    public ObservableList<Contact> getContacts() { return contacts; }
    
    public void addContact(Contact contact) { contacts.add(contact); }

    public void deleteContact(Contact contact) { contacts.remove(contact); }
    
    public void loadContacts() throws IOException { 
        Path path = Paths.get(filename);

        try (BufferedReader br = Files.newBufferedReader(path)) {
            String input;
            while ((input = br.readLine()) != null) {
                String[] itemPieces = input.split("\t");
                String firstName = itemPieces[0];
                String lastName = itemPieces[1];
                String phoneNumber = itemPieces[2];
                String notes = itemPieces[3];

                Contact contact = new Contact(firstName, lastName, phoneNumber, notes);
                contacts.add(contact);
            }
        }
    }

    public void saveContacts() throws IOException {
        Path path = Paths.get(filename);
        try(BufferedWriter bw = Files.newBufferedWriter(path)) {
            Iterator<Contact> iter = contacts.iterator();
            for(Contact contact : contacts) {
                bw.write(String.format("%s\t%s\t%s\t%s", contact.getFirstName(), contact.getLastName(),
                        contact.getPhoneNumber(), contact.getNotes()));
                bw.newLine();
            }
        }
    }
}
