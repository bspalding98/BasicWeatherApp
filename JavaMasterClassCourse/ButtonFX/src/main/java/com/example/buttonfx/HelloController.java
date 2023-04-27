package com.example.buttonfx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

// whenever we see an anonymous class definition that overrides one method
    // Can just use lambda

public class HelloController {
    @FXML
    private Button clickMeButton;

    public void initialize() {
        // Without lambda
//        clickMeButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("You clicked me!");
//            }
//        });

        // With lambda
        clickMeButton.setOnAction(event -> System.out.println("You clicked me!"));
    }
}