package com.example.fxapplications.checkers.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainMenuController {

    @FXML
    private Button newGameButton;

    public void initialize() {
        newGameButton.setOnAction(event -> System.out.println("You clicked me!"));
    }
}
