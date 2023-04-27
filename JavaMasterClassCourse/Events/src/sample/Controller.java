package sample;

// When something is interacted with say a button. The UI thread will spark and check if there is anything to execute based on the event
// Sometimes event handlers are known as EventListeners - It's listening for an event

// GOOD IDEA TO Annotate event handlers. For looking at code later one or others. Easier to see


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

public class Controller {
    @FXML   // This essentially makes sure to look for matching variables in the fxml and associates the two (Must be exact same match)
    private TextField nameField;
    @FXML
    private Button helloButton;
    @FXML
    private Button byeButton;
    @FXML
    private CheckBox ourCheckBox;
    @FXML
    private Label ourLabel;

    @FXML
    public void initialize() {  // cannot have parameters and must be public. JavaFX calls this method when initialising UI.
//        Doing this to disable buttons originally. as by default setDisable = false
        helloButton.setDisable(true);
        byeButton.setDisable(true);
    }

    @FXML
    // So instead of having an IF to make sure the user input field is not empty. It's better to disable the buttons when there is nothing in the text field.
    public void onButtonClicked(ActionEvent e){ // Might want to use same event handler for more than one control. So adding a parameter can be good
        if(e.getSource().equals(helloButton)) System.out.println("Hello, " + nameField.getText()); // Tells you which control was pressed
        else if(e.getSource().equals(byeButton)) System.out.println("Bye, " + nameField.getText());

        Runnable task = new Runnable() {    // Pretty much this is used to delegate time-consuming task executions to background threads. Since javafx not thread safe only allowed to use the one thread to access and modify the UI
            @Override
            public void run() {
                try {
                    // is.FXApplicationThread. This is checking if it is running on the UI thread or not. So you can see it better
                    String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                    System.out.println("I'm going to sleep on the: " + s);
                    Thread.sleep(10000);
                    Platform.runLater(new Runnable() {  // Makes it update on the UI thread. Because javaFx only want stuff updated on one thread the Javafx application thread
                        // So pretty much it puts it to sleep above in the background. Then once it is done, and there is time between inputs. It runs this one back on the UI thread.
                        // SO I think in this instance it would be useful if say I needed to retrieve data from a database. Instead of waiting for the thread to get it
                            // I can just put it on a background thread. then when it has retrieved it. Pass it back to the UI thread??
                        @Override
                        public void run() {
                            String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                            System.out.println("I'm updating the label on the: " + s);
                            ourLabel.setText("We did something!");
                        }
                    });
                } catch(InterruptedException event) {
                    // we don't care about this part
                }
            }
        };

        new Thread(task).start();

        if(ourCheckBox.isSelected()) {
            nameField.clear();
//            ourCheckBox.setSelected(false);
            handleKeyReleased();    // He recons this might not work depending on what is in the nameField but I cannot see it. He just manually disabled them again. Like in initialize()
        }
    }

    @FXML
    public void handleKeyReleased() {   // Do not want to make it on press. Because on checks once pressed. So the first initial char input will no register until the second char is typed
        String text = nameField.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty();   // trim() removes spaces - so in someone is just putting spaces in field it would cater for that now
        helloButton.setDisable(disableButtons); // setDisable() disables the button with true or false.
        byeButton.setDisable(disableButtons);
    }

    @FXML
    public void handleChange() {    // Could be in onButtonClicked but then would have to nest the it(ourCheckBox) in both if and else if which is duplicated code.
        System.out.println("The checkbox is " + ((ourCheckBox.isSelected()) ? "checked" : "not checked"));
    }
}
