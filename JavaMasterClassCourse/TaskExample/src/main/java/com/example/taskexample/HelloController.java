package com.example.taskexample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;

// updating background thread task into UI as all threads must run through one javafx main thread ??
// use runlater and it runs it on UI thread later???

// So this is performing a long-running task on the background thread and updating it on the UI


// USING A SERVICE , comment out and delete most of other part to do it using task in main and not services
// THIS IS RECOMMENDED WAY TO RUN THREADS - also a Java service runtime to manage threads for us


public class HelloController {

//    private Task<ObservableList<String>> task;

    @FXML
    private ListView listView;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Label progressLabel;
    @FXML
    private Service<ObservableList<String>> service;

    // This is bad practice tho
//    public void initialize() {
//        task = new Task<ObservableList<String>>() {
//            @Override
//            protected ObservableList<String> call() throws Exception {
//                Thread.sleep(1000); // This is simulating the database fetch
//                ObservableList<String> employees = FXCollections.observableArrayList(
//                        "Boyd Spalding",
//                        "Chris Evans",
//                        "Becky White",
//                        "Michael Jordan",
//                        "Lebron James",
//                        "Christina Postma");
//                Platform.runLater(new Runnable() {
//                    @Override
//                    public void run() {
//                        listView.setItems(employees);   // since updating listView from task, don't need to return it to update UI??
//                    }
//                });
//
//                return employees;
//            }
//        };
//    }

    // Better:
    public void initialize() {
//        task = new Task<ObservableList<String>>() {
//            @Override
//            protected ObservableList<String> call() throws Exception {
//
//                String[] names = { "Boyd Spalding",
//                        "Chris Evans",
//                        "Becky White",
//                        "Michael Jordan",
//                        "Lebron James",
//                        "Christina Postma"};
//
//                ObservableList<String> employees = FXCollections.observableArrayList();
//
//                for(int i =0; i < 6; i ++) {
//                    employees.addAll(names[i]);
//                    updateMessage("Added " + names[i] + " to the list");
//                    updateProgress(i + 1, 6);   // (current progress, max progress) - sometimes max cna change why we pass it everytime
//                    Thread.sleep(1200);
//                }
//
//                updateMessage("Complete :)");
//                return employees;   // return here, so we can update the UI from a task
//            }
//        };
        service = new EmployeeService();

        // Data Binding everything together
        progressLabel.textProperty().bind(service.messageProperty());
        progressBar.progressProperty().bind(service.progressProperty());
        listView.itemsProperty().bind(service.valueProperty());    // This will bind the listView items property to the tasks value property

//        service.setOnRunning(new EventHandler<WorkerStateEvent>() {
//            @Override
//            public void handle(WorkerStateEvent event) {
//                progressBar.setVisible(true);
//                progressLabel.setVisible(true);
//
//            }
//        });
//
//        service.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//            @Override
//            public void handle(WorkerStateEvent event) {
//                progressBar.setVisible(false);
//                progressLabel.setVisible(false);
//            }
//        });
//
//        progressBar.setVisible(false);
//        progressLabel.setVisible(false);

        // Instead we can bind
        progressBar.visibleProperty().bind(service.runningProperty());
        progressLabel.visibleProperty().bind(service.runningProperty());
    }



    // service can be run many times
    // but must be in ready state
    // once completed it is in succeeded state so need to reset it
    @FXML
    public void buttonPressed() {
        if(service.getState() == Service.State.SUCCEEDED) {
            service.reset();
            service.start();
        } else if(service.getState() == Service.State.READY) {
            service.start();
        }
    }
}