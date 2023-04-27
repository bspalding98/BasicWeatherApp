package com.company;

// JDBC = Java DataBase Connectivity

// Using sqlite connecting to a database that doesn't exist will create on automatically
    // Don't need to do it in a separate step like others

// all JDBC drivers need a data string to connect to a database
    // format varies between database - only common thing is jdbc:
    // Can also specific the attributes with this

// Two ways of establishing connecting for jdbc
    // Driver manager
    // Datasource objects

// Good practice closing a resource after using it - connection (Done with try with resources)

// jdbc auto commits changes after each statement
    // sometimes you need to explicitly commit and if you don't, they roll back and you lose the data
    // Will be explained later
    // BUT default behaviour is to auto commit


// ALSO CAN YOU QUOTE FOR STRING BUT YOU NEED TO ESCAPE THEM THEN SO SINGLE IS JUST EASIER

// need new statement for each query when using them together

// Can also use column indices to retrieve values instead of the column names
    // indices is also faster, so it's the preferred way to do it.

// CRUD
    // Create, Read, Update, Delete


import org.sqlite.core.DB;

import java.sql.*;

public class Main {

    // THis is all hardcoded atm in this main() below
    // Bad practice to type it in every single time
    // Using hardcoded strings makes the application vulnerable to SQL attacks
//    public static void main(String[] args) {
//        // USing try with resources
//
////        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\boyd9\\Documents\\JavaCourse\\TestDB\\testjava.db");
////            Statement statement = conn.createStatement()) {
////                statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT)");
////        } catch (SQLException e ) {
////            System.out.println("Something went worng: " + e.getMessage());
////        }
//
//        //without resources
//        try {
//            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\boyd9\\Documents\\JavaCourse\\TestDB\\testjava.db");
//            Statement statement = conn.createStatement();
//            // Stop auto commit changes
////            conn.setAutoCommit(false);
//            // IF NOT EXISTS ensures that it only creates the table if there isn't one, this prevents errors
//            statement.execute("CREATE TABLE IF NOT EXISTS contacts " +
//                                    "(name TEXT, phone INTEGER, email TEXT)");
//
//            // Create new data to table
////            statement.execute("INSERT INTO contacts (name, phone, email)" +
////                    "VALUES('Tim', 45632, 'Tim@email.com')");
////
////            statement.execute("INSERT INTO contacts (name, phone, email)" +
////                    "VALUES('Jane', 4829484, 'Jane@somewhere.com')");
////
////            statement.execute("INSERT INTO contacts (name, phone, email)" +
////                    "VALUES('Fido', 9038, 'dog@email.com')");
//
//            // updating data in the table
////            statement.execute("UPDATE contacts SET phone=5566789 WHERE name='Jane'");
//
//            // Deleting data in the table
////            statement.execute("DELETE FROM contacts WHERE name='Tim'");
//
//
//            // Retrieve all the data from the table
//            // boolean true if returns an instance
////            statement.execute("SELECT * FROM contacts");
////            ResultSet results = statement.getResultSet();
//            // EASIER way with query to above
//            ResultSet results = statement.executeQuery("SELECT * FROM contacts");
//            while(results.next()) {
//                System.out.printf("%s %d %s\n", results.getString("name"), results.getInt("phone"), results.getString("email"));
//            }
//            results.close();
//
//
//
//            // Have to manually close them
//            statement.close();
//            conn.close();
//        }catch (SQLException e ) {
//            System.out.println("Something went worng: " + e.getMessage());
//        }
//    }




    // Better one
    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\boyd9\\Documents\\JavaCourse\\TestDB\\" + DB_NAME;

    public static final String TABLE_CONTACTS = "contacts";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {

        //without resources
        try (Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement()) {

            //Drop table if exists
            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
            //Create table if not exists - Could also use String.format
            statement.execute(String.format("CREATE TABLE IF NOT EXISTS %s (%s text, %s integer, %s text)",
                    TABLE_CONTACTS, COLUMN_NAME, COLUMN_PHONE, COLUMN_EMAIL));

            // inserts
            insertContact(statement,"TIm", 6545678, "tim@email.com");
            insertContact(statement,"Joe", 45632, "joe@anywhere.com");
            insertContact(statement,"Jane", 4829484, "jane@somewhere.com");
            insertContact(statement,"Fido", 9038, "dog@email.com");

            //update
            statement.execute(String.format("UPDATE %s SET %s=%d WHERE %s='%s'",
                    TABLE_CONTACTS, COLUMN_PHONE, 566789, COLUMN_NAME, "Jane"));

            // delete
            statement.execute("DELETE FROM " + TABLE_CONTACTS +
                    " WHERE " + COLUMN_NAME + "='Joe'");


            ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS);
            while(results.next()) {
                System.out.printf("%s %d %s\n", results.getString(COLUMN_NAME), results.getInt(COLUMN_PHONE), results.getString(COLUMN_EMAIL));
            }
            results.close();    // Could put the above part in a try with resources as well I think

        }catch (SQLException e ) {
            System.out.println("Something went worng: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void insertContact(Statement statement, String name, int phone, String email) throws SQLException {  // coz catching in main() where this is being called so no need for try and catch
        statement.execute(String.format("INSERT INTO %s (%s, %s, %s) VALUES('%s', %d, '%s')",
                TABLE_CONTACTS, COLUMN_NAME, COLUMN_PHONE, COLUMN_EMAIL, name, phone, email));
    }
}
