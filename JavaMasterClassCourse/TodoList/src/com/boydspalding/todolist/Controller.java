package com.boydspalding.todolist;

import com.boydspalding.todolist.datamodel.TodoData;
import com.boydspalding.todolist.datamodel.TodoItem;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Controller {
    // Could figure out how to check whether edit or new was clicked and depending either run the last bit of dialog(). Because it is duplicated pretty much

    private List<TodoItem> todoItems;
    private FilteredList<TodoItem> filteredList;
    private Predicate<TodoItem> wantAllItems;
    private Predicate<TodoItem> wantTodaysItems;

    @FXML
    private ListView<TodoItem> todoListView;
    @FXML
    private TextArea itemDetailsTextArea;
    @FXML
    private Label deadlineLabel;
    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private ContextMenu listContextMenu;    // ContextMenu is when you rightClick on something
    @FXML
    private ToggleButton filterToggleButton;


    public void initialize() {
        listContextMenu = new ContextMenu();
        MenuItem  deleteMenuItem = new MenuItem("Delete");
        deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {    // Setting an onAction event handler. Idk why not doing it in fxml. Mayeb cant override then?
            @Override
            public void handle(ActionEvent actionEvent) {
                TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                deleteItem(item);
            }
        });

        MenuItem  editMenuItem = new MenuItem("Edit");
        editMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                editItemDialog();
            }
        });

        listContextMenu.getItems().addAll(deleteMenuItem, editMenuItem);  // Added this option to the context Menu idk why it wasn't done above - adds all Menu items to the object

        //NONE OF THIS IS NEEDED NOW BECAUSE IT WILL WRITE A DUP EVERYTIME OTHERWISE since we are loading and write everytime
//        // This is just placehold data until we have coded the UI that will let the users add the items
//        // THis is just sample data for just testing purposes.
//        TodoItem item1 = new TodoItem("Mail birthday card", "Buy a 30th birthday card for John",
//                LocalDate.of(2022, Month.APRIL, 25));
//        TodoItem item2 = new TodoItem("Doctor's Appointment", "See Dr. Smith at 123 Main Street.",
//                LocalDate.of(2022, Month.MARCH, 25));
//        TodoItem item3 = new TodoItem("Finish design proposal for client",
//                "I promised Mike I'd website mockups by Friday 1st April",
//                LocalDate.of(2016, Month.APRIL, 1));
//        TodoItem item4 = new TodoItem("Pickup Doug at the train station",
//                "Doug's arriving on August 25 on the 5:00 train",
//                LocalDate.of(2021, Month.AUGUST, 25));
//        TodoItem item5 = new TodoItem("Pickup dry cleaning", "Clothes should be ready by Wednesday",
//                LocalDate.of(2021, Month.DECEMBER, 25));
//
//        // Created ArrayList and added the items to it
//        todoItems = new ArrayList<>();
//        todoItems.add(item1);
//        todoItems.add(item2);
//        todoItems.add(item3);
//        todoItems.add(item4);
//        todoItems.add(item5);
//
//
//        // THIS IS ONLY TEMP only done once to create the file with these hardcoded items so it's in there
//        TodoData.getInstance().setTodoItems(todoItems);



        //Not Sure what is going on. This is a generic EventHandler or eventlsitener code that we changed.
        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {    // This is auto selecting first one and listening?
            @Override
            public void changed(ObservableValue<? extends TodoItem> observableValue, TodoItem oldValue, TodoItem newValue) {
                if(newValue != null) {
                    TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy"); // Formats the date better - several differ formatting options
                    deadlineLabel.setText(df.format(item.getDeadline()));   // passing in a date to gf in order to format it.
                }
            }
        });

        //Creating the filtered list
        // wrap he observable Arraylist in the filteredList, then wrap this in the sortedList
        wantAllItems = new Predicate<TodoItem>() {
            @Override
            public boolean test(TodoItem item) {
                return true;
            }
        };
        wantTodaysItems = new Predicate<TodoItem>() {
            @Override
            public boolean test(TodoItem item) {
                return (item.getDeadline().equals(LocalDate.now()));
            }
        };
        filteredList = new FilteredList<TodoItem>(TodoData.getInstance().getTodoItems(), wantAllItems);


        // Sorting the list with the comparator in terms for due date. (Only in javafx)
        // Still using observable arraylist. Wrap it in a sorted list.
        // So then effectively the sortedlist will update the listView and when lists is changed it will still update due to observable arraylist
        // Passing in TodoItems to compare with 01 and 02
        SortedList<TodoItem> sortedList = new SortedList<TodoItem>(filteredList, new Comparator<TodoItem>() { // Essentially since FilteredList is added in here now. What that means is that this sortedList will technically still wrap the Obersavble ArrayList becasue it wraps the filteredList and the filteredList wraps the Observable ArrayList
            @Override
            public int compare(TodoItem o1, TodoItem o2) {
                return o1.getDeadline().compareTo(o2.getDeadline()); // This is comparing the deadline dates of the two ListView items
            }
        });




    // THIS NOW CHANGED TO GET OUT SINGLETON CLASS TO LOAD THE ITEMS PROPERLY
//        todoListView.setItems(TodoData.getInstance().getTodoItems());
        //CHANGING LINE ABOVE TO NOW SET THE SORTED LIST
        todoListView.setItems(sortedList); // They now use the sortedList wrapped inside in the observable ArrayList to update it instantly with data binding and also ensure it is always sorted
        // Populating the ListView fxml
//        todoListView.getItems().setAll(todoItems);  // This is returning toString() so need to override in TodoItem class.
        // Making on 1 selected at a time - However by default it is just one
        // todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        todoListView.getSelectionModel().selectFirst(); // Now with listener above this works

        // Change the cell in a list depending on something
        // THis could be in todoItem class and tostring(). Since this is here now. do not need that method anymore
        todoListView.setCellFactory(new Callback<ListView<TodoItem>, ListCell<TodoItem>>() {    // SetCellFactory means setting the cells in the list // callback interface javafx API. 1st par is type of arguement provided by call method (so the one we wont to change the cell factory)_, 2nd is what is going to be returned "TodoItem is generic"
            // So the callback method will return the cell instance created and the listView will use the instance to paint the cell
            // Allows us to paint every cell based on the todoItem it contains.
            @Override
            public ListCell<TodoItem> call(ListView<TodoItem> todoItemListView) {
                ListCell<TodoItem> cell = new ListCell<>() {    // set cell?
                    @Override
                    protected void updateItem(TodoItem todoItem, boolean b) {   // updating cell attributes? b means empty
                        super.updateItem(todoItem, b);
                        if(b) setText(null);
                        else {
                            setText(todoItem.getShortDescription());
                            if(todoItem.getDeadline().isBefore(LocalDate.now().plusDays(1))) {
                                setTextFill(Color.RED);
                            } else if(todoItem.getDeadline().equals(LocalDate.now().plusDays(1))) {
                                setTextFill(Color.BLUE);
                            } else if(todoItem.getDeadline().isAfter(LocalDate.now().plusDays(7))){
                                setTextFill(Color.GREEN);
                            }
                        }
                    }
                };
                cell.emptyProperty().addListener(   // Don't really understand why tbh and why in the cellFactory --- I think it's saying if the cell is not empty. you can right click. hence why in cellFactory because it's the make up or function of it???
                        // Think we added a listener for the cells empty property. If it is not empty
                        // The contextMenu created will be associated with it. If it is empty we will not
                        // by setting contextmenu to null
                        (obs, wasEmpty, isNowEmpty) -> {
                            if(isNowEmpty) {
                                cell.setContextMenu(null);
                            } else {
                                cell.setContextMenu(listContextMenu);   // Saying that this cell will show the contextMenu if rightclicked.
                            }
                        }
                );
                return cell;
            }
        });
    }

    @FXML
    public void showNewItemDialog() {
        Dialog<ButtonType> dialog = new Dialog<>(); // Built in class that wraps a dialogPane and provides the necessary API to present it to end users
        // Make it modal - while this is open, the user cannot interact with any of the other UI - only dialog --- DONE BY DEFAULT SO DON'T DO ANYTHING
        dialog.initOwner(mainBorderPane.getScene().getWindow());    // gives new object dialog a parent window which is the main window
        dialog.setTitle("Add New Todo Item");
        dialog.setHeaderText("Use this dialog to create a new todo item");  // Can do this or headText in this fxml

        // gets access to the fxml loader instances
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("todoItemDialog.fxml"));
        // Then try open it through the main window now.
        try {   // Doing this because it can through an IO exception
            dialog.getDialogPane().setContent(fxmlLoader.load());    // Think gets the dialogPane created and stores in the fxml file above and sets the contents of it with the fxml content

        } catch(IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        // Creating some buttons - only these buttons and exit button from the new window will exit out due to default modal
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        // show will bring up a non blocking dialog. will return immediately after showing dialog, will not need to press ok or cancel???
        // Show and wait will bring up a blocking dialog - this is generally the one used
        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            DialogueController controller = fxmlLoader.getController();
            TodoItem newItem = controller.processResults();
            // No longer need as we changed it to a observableList so it auto listens and updates it
//            todoListView.getItems().setAll(TodoData.getInstance().getTodoItems());  // This replaces the contents with the new data instantly while still open.
            todoListView.getSelectionModel().select(newItem);   // Selects the new item added
        }
    }

    @FXML
    public void deleteItem(TodoItem item) {
        // Few canned dialogs for common use cases
        // using confirmation dialog to confirm they want to delete them
        // This is done through an alert class - When we create an instance of Alert, must pass in 1 of 5 types
            // Confirmation, error, information, warning, none - Based on type, alert constructor will initialise them based on what we choose
            // why none, no properties that get initialised, so want to set each property yourself
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);  // ASks user for confirmation
        // Set what the dialog will display on the screen
        alert.setTitle("Delete Todo Item");
        alert.setHeaderText("Delete item: " + item.getShortDescription());
        alert.setContentText("Are you sure? Press OK to confirm, or CANCEL to back out");
        // Alert class auto sets button based on alert type. - CONFIRMATION is an OK And Cancel button
        Optional<ButtonType> result = alert.showAndWait();  // shows dialog and wait for selection

        if(result.isPresent() && result.get() == ButtonType.OK) {
            TodoData.getInstance().deleteTodoItem(item);
        }

    }

    @FXML
    public void editItemDialog() {
        TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();   // Gets the item selected to update after inputs

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());    // allows us to create the dialog pane through the main window?
        dialog.setTitle("Editing: " + selectedItem.getShortDescription());

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("todoItemDialog.fxml"));  // creating the dialogpane in the loader
        try {
            dialog.getDialogPane().setContentText(fxmlLoader.load());    // tries to load the UI with this fxml file

        } catch(IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            DialogueController controller = fxmlLoader.getController(); // Making a new DialogueController instance and getting info needed from fxml fields
            TodoItem updatedItem = controller.editDialog(selectedItem);
            todoListView.getSelectionModel().clearSelection();      // This fix it WHY??? clears the selection and below reselects it I think. Have to clear I guess --> Do I need this now becasue with wrapping the observable Arraylist in the sortedlist, etc. It updates without it.
            todoListView.getSelectionModel().select(updatedItem);
        }
    }

    @FXML
    public void handleKeyPressed(KeyEvent keyEvent) {
        TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
        if(selectedItem != null) {
            if(keyEvent.getCode().equals(KeyCode.DELETE)) deleteItem(selectedItem);
        }
    }

    @FXML
    public void handleFilterButton() {
        TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
        if(filterToggleButton.isSelected()) {
            // FilteredList in javafx. Going to wrap the observable Arraylist in the filteredlist. and then wrapping it in sortedList?
            filteredList.setPredicate(wantTodaysItems);
            if(filteredList.isEmpty()) {
                itemDetailsTextArea.clear();    // Setting text area and due date to empty
                deadlineLabel.setText("");
            } else if(filteredList.contains(selectedItem)) {
                todoListView.getSelectionModel().select(selectedItem);
            } else {
                todoListView.getSelectionModel().selectFirst();
            }
        } else {
            filteredList.setPredicate(wantAllItems);
            todoListView.getSelectionModel().select(selectedItem);
        }
    }

    @FXML
    public void handleExit() {
        Platform.exit();
    }



// NO longer needed with generic eventlistener we created.
//    @FXML
//    public void handleClickedListView() { // Did not have initial list selected
//        // Javafx control is backed by a selected model which tracks which item is selected by the control. So that's how we can get the selected item.
//        // Selection model tracks which item is selected by the control.
//        TodoItem item = todoListView.getSelectionModel().getSelectedItem();  // Gets the item that is selected in the ListView.
////        System.out.println("Selected item is " + item); // This prints the (toString()) as well I think
//        itemDetailsTextArea.setText(item.getDetails());
//        deadlineLabel.setText(item.getDeadline().toString());   // because it is a date, need to to toString() so make it a string
////        // BETTER way to also include date
////        StringBuilder sb = new StringBuilder(item.getDetails());
////        sb.append("\n\n\n\n");
////        sb.append("Due: ");
////        sb.append(item.getDeadline());
////        itemDetailsTextArea.setText(sb.toString()); // Need toString() because sb is a StringBuilder type and we need a String type.
//    }
}
