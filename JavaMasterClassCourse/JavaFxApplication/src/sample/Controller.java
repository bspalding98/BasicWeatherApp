package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class Controller {
    // CSS inline overrides css in the stylesheet. Doing inline though is not recommended. Do it all on css probably.
    // Adding a drop shadow on code because he said on fxml when he did it. added effects was a bit buggy for fxml
    //FileChooser UI cannot be embedded into a UI layout and shouldn't need to be either

    @FXML
    private Label label;
    @FXML
    private Button button4;
    @FXML
    private GridPane gridPane;
    @FXML
    private WebView webView;

    public void initialize() {
        button4.setEffect(new DropShadow());
    }

    @FXML
    public void handleMouseEnter() {
        label.setScaleX(2.0);
        label.setScaleY(2.0);
    }

    @FXML
    public void handleMouseExit () {
        label.setScaleX(1.0);
        label.setScaleY(1.0);
    }

    @FXML
    public void handleClick() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Save Application File");
        chooser.getExtensionFilters().addAll(   // This limits what file types someone can save the file as? When you have these limitations for openDialog. Only shows or highlights those files that match those extentions.
                new FileChooser.ExtensionFilter("Text", "*.txt"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.gif"),
                new FileChooser.ExtensionFilter("ALL.Files", "*.*"));   // Allows for user to save any file as they please still
//        chooser.showOpenDialog(gridPane.getScene().getWindow());   // Passing in mainWindow instead of null so nothing else can be interacted with when doing this. Making it modal. Stop it from being buggy
        // Can use directory chooser to open a directory - So now can choose a folder instead of having it to be a file. - cannot even see the folders anymore
//        DirectoryChooser chooser = new DirectoryChooser();
//        File file = chooser.showOpenDialog(gridPane.getScene().getWindow());    // showOpenDialog opens a file or folder. showSaveDialog is to save the file or folder.
//        if(file != null) System.out.println(file.getPath());
//        else System.out.println("Chooser was cancelled");
        List<File> file = chooser.showOpenMultipleDialog(gridPane.getScene().getWindow());    // Allows you to open several files at once
        if(file != null) {
            for (File value : file) {
                System.out.println(value);
            }
        }
        else System.out.println("Chooser was cancelled");
    }

    @FXML
    public void handleLinkClicked() {
        // How to visit a webpage - goes to link onto new into tab
//        try {
//            Desktop.getDesktop().browse(new URI("http://www.javafx.com"));
//        } catch(IOException | URISyntaxException e) {
//            e.printStackTrace();
//        }
        // Creating a WebView page so you can view the webpage on the application through the link instead of a new browser tab
        // WebEngine for documentation - It can even run the javascript on the pages
        WebEngine engine = webView.getEngine();
        engine.load("http://www.javafx.com");
    }


}
