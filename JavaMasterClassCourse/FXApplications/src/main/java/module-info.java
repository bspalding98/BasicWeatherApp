module com.example.fxapplications {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires javafx.graphics;

    opens com.example.fxapplications to javafx.fxml;
    exports com.example.fxapplications.checkers;
    exports com.example.fxapplications.checkers.constants;
    exports com.example.fxapplications.checkers.controllers;
}