package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class Main extends Application { // Application is abstract so must extend from it where you want to create the UI
// Stage is top level javafx container.
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));   // This is where all the UI elements are constructed??? Parent is base class for scene graph nodes


//        GridPane root = new GridPane();
//        root.setAlignment(Pos.CENTER);
//        root.setVgap(10);
//        root.setHgap(10);
//
//        Label greeting = new Label("Welcome to JavaFX!");
//        greeting.setTextFill(Color.GREEN);  // Changing text colour.
//        greeting.setFont(Font.font("Times New Roman", FontWeight.BOLD, 70));     // Setting font to bold and changing size
//        root.getChildren().addAll(greeting);    // Getting the list of the children in the GridPane and adding the label to the list

        // The below are needed I am pretty sure
        primaryStage.setTitle("Hello JavaFX!");
        primaryStage.setScene(new Scene(root, 700, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
