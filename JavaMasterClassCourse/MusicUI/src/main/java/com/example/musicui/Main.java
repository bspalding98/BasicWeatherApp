package com.example.musicui;

import com.example.musicui.model.Datasource;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// When deleting nad inserting data into the database through UI, can keep them in sync by querying everytime you insert or delete
    // Alright there coz small but bigger applications it's bad performance wise I think

// could just manually update database instead and with data binding, it would update in the table
    // So you update the Ui after the database operations has successfully completed
    // Don't do UI first because if something was to go wrong, it would most likely be in database
    // If UI gets updated and database doesn't, data is out of sync
    // If other way, it is not as bad

// So do database using task
    // then update UI using the task.onsucceded method?


public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        // Have artists list when created.
        Controller controller = fxmlLoader.getController();
        controller.listArtists();

        stage.setTitle("Music Database");
        stage.setScene(scene);
        stage.show();
    }

    // runs before anything else
    @Override
    public void init() throws Exception {
        super.init();
        // Is is because the UI will still open if we don't do this. So if it opens and database did not connect. Everything the user will do will error
        if(!Datasource.getInstance().open()) {
            System.out.printf("FATAL ERROR: Couldn't connect to database");
            Platform.exit();
        }
    }

    // runs last before app closes
    @Override
    public void stop() throws Exception {
        super.stop();
        Datasource.getInstance().close();
    }

    public static void main(String[] args) {
        launch();
    }
}