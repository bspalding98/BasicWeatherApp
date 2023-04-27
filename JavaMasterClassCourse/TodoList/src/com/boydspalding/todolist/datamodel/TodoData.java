package com.boydspalding.todolist.datamodel;

//Singleton class
// Created when you only ever want one instance of this class at a time
    // Seems like it would be good for save and load????

// REMEMBER made poorly just to get it done fast as we were not learning this yet


// IN A REAL APP we would probably store to an xml or a database
    // Using a txt file for large amounts become impractical

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

public class TodoData {
    private static TodoData instance = new TodoData();
    private static String filename = "TodoListItems.txt";

    private ObservableList<TodoItem> todoItems;
    private DateTimeFormatter formatter;

    public static TodoData getInstance() {  // Think having this makes only one instance allowed at the same time because it creates a new one each time?
        return instance;
    }

    private TodoData() {    // private constructor
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public ObservableList<TodoItem> getTodoItems() {
        return todoItems;
    }
    public void addTodoItem(TodoItem item) {
        todoItems.add(item);
    }

//    public void setTodoItems(List<TodoItem> todoItems) {    // Temp, only need when we run and close app to save hardcoded items
//        this.todoItems = todoItems;
//    }

    // Load data from file to List
    public void loadTodoItems() throws IOException {

        // This is for performance reasons. So it auto updates the list. FXCollections also takes less processing only brings up limited number of notifications java.util does it multiple times maybe for multiple occasions.
        todoItems = FXCollections.observableArrayList();    // Makes it so if there is nothing in the ArrayList. it will be empty but can still be used and won't be seen as null. Which will cause an exception error. so can use setALL in controller class initialize()??
        Path path = Paths.get(filename);    // Finds path
        BufferedReader br = Files.newBufferedReader(path);  // This is point to location where the file is and creates a buffered reader for the file

        String input; // Will hold data for each line

        try {
            while((input = br.readLine()) != null) {    // While the line being read contains data?
                String[] itemPieces = input.split("\t");        // Splitting each line of data (1 item into separate parts) by \t which is what is used when saving it to split data

                // This now gets each piece of data in the object alone to use
                String shortDescription = itemPieces[0];
                String details = itemPieces[1];
                String dateString = itemPieces[2];
                // Converting Date into a string and formatting to what we made at the top
                LocalDate date = LocalDate.parse(dateString, formatter);

                TodoItem todoItem = new TodoItem(shortDescription, details, date);  // Create a TodoItem now to use
                todoItems.add(todoItem); // To make an ArrayList od the items to use for ListView.
            }
        } finally {
            if(br != null) br.close();  // Makes sure object is valid
        }
    }

    // Saving data from list to file
    public void storeTodoItems() throws IOException {
        Path path = Paths.get(filename);
        //THIS IS THE BETTER WAY TO DO TRY WITH RESOURCES
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            // Going to iterate through list and same them one at a time to txt file.
            Iterator<TodoItem> iter = todoItems.iterator(); // Builds an iterator to cycle through each entry of todoItems ArrayList.   -- need to remember this just creates the iterator. Still need to do .next() to get to the first index or index0???
            while(iter.hasNext()) { // Checking if there is another entry to be used. If so will run the code block which will save to txt file.
                TodoItem item = iter.next();    // Gets the next item one at a time.
                // This formats each txt file line this way to keep each bit of data separate in the entry and has to be set the same way as the loader so the loader can put it back together properly
                bw.write(String.format("%s\t%s\t%s",
                        item.getShortDescription(), item.getDetails(), item.getDeadline().format(formatter)));
                bw.newLine();   // Goes to new line in txt file so next entry in the todoItems ArrayList is entered on a separate line

            }
        }
    }

    public void deleteTodoItem(TodoItem item) {
        todoItems.remove(item); // remember since it's an observableList, it auto updates the list everywhere.
    }

    public void updateTodoItem(TodoItem item) {
        todoItems.set(todoItems.indexOf(item), item);
    }
}
