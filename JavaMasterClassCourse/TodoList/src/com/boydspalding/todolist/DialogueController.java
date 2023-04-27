package com.boydspalding.todolist;

import com.boydspalding.todolist.datamodel.TodoData;
import com.boydspalding.todolist.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class DialogueController {
    @FXML
    private TextField shortDescriptionField;
    @FXML
    private TextArea detailsArea;
    @FXML
    private DatePicker deadlinePicker;

    public TodoItem processResults() {  // returning todoItem so we can make it auto select the item in the list once added in
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadlineValue = deadlinePicker.getValue();

        TodoItem newItem = new TodoItem(shortDescription, details, deadlineValue);
        TodoData.getInstance().addTodoItem(newItem);
        return newItem;
    }

    public TodoItem editDialog(TodoItem item) {
        item.setShortDescription(shortDescriptionField.getText().trim());
        item.setDetails(detailsArea.getText().trim());
        item.setDeadline(deadlinePicker.getValue());

        TodoData.getInstance().updateTodoItem(item);

        return item;
    }
}
