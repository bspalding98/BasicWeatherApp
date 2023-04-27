package com.boydspalding.todolist;

//OBERSVABLELIST IS A TYPE OF DATA BINDING I THINK

import com.boydspalding.todolist.datamodel.TodoData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainwindow.fxml"));
        primaryStage.setTitle("Todo List");
        primaryStage.setScene(new Scene(root, 900, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    // This is getting done to store our items in the file
    public void stop() throws Exception {
        try {
            TodoData.getInstance().storeTodoItems();    // saves the data to the text file
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    // This is loading the items from the file
    public void init() throws Exception {
        try {
            TodoData.getInstance().loadTodoItems();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
