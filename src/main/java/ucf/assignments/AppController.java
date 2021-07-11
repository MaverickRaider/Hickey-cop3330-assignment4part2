/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Michael Hickey
 */


package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AppController {
    @FXML
    private TableView<Task> taskTable;
    @FXML
    private TableColumn<Task, String> taskColumn;
    @FXML
    private TableColumn<Task, String> statusColumn;
    @FXML
    private Label taskLabel;
    @FXML
    private TextArea descriptionArea;
    @FXML
    private Label dueDateLabel;
    @FXML
    private Label statusLabel;

    // Reference to the main application.
    private App mainApp;

    // Constructor before Initialization
    public AppController() {
    }

    // Initializes the controller class
    @FXML
    private void initialize() {
        // Initialize the table with the two columns, one is the task name and the other its the status
        taskColumn.setCellValueFactory(cellData -> cellData.getValue().taskLabelProperty());
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().taskCompletedColumnProperty());

        // Clear task details from screen
        showTaskDetails(null);

        // Shows the tasks once user selects it
        taskTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showTaskDetails(newValue));
    }

    // Makes an instance of the main app
    public void setMainApp(App mainApp) {
        this.mainApp = mainApp;

        // Generates all data to the table
        taskTable.setItems(mainApp.getTaskData());
    }

    // Show tasks on screen
    private void showTaskDetails(Task todoTask) {
        if (todoTask != null) {
            taskLabel.setText(todoTask.getTaskLabel());
            descriptionArea.setText(todoTask.getDescription());
            statusLabel.setText(todoTask.getTaskStatus());
            dueDateLabel.setText(DateUtil.format(todoTask.getDueDate()));
        } else {
            // If there is no Task displayed, then all fields are blank
            taskLabel.setText("");
            descriptionArea.setText("");
            statusLabel.setText("");
            dueDateLabel.setText("");
        }
    }

    // New button is clicked
    @FXML
    private void newButtonClicked() {
        handleNewTask();
    }
    // Creates a new task then adds it to the data
    private void handleNewTask() {
        Task tempTask = new Task();
        boolean okClicked = mainApp.showTaskEditor(tempTask);
        if (okClicked) {
            mainApp.getTaskData().add(tempTask);
        }
    }

    // Edit button is clicked
    @FXML
    private void editButtonClicked() {
        handleEditTask();
    }
    // Takes the task index and overwrites it
    private void handleEditTask() {
        Task selectedTask = taskTable.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            boolean okClicked = mainApp.showTaskEditor(selectedTask);
            if (okClicked) {
                showTaskDetails(selectedTask);
            }
        } else {
            // If nothing selected error out
            errorReport();
        }
    }

    // Delete Button is clicked
    @FXML
    private void deleteButtonClicked() {
        handleDeleteTask();
    }
    // Takes index and remove the element completely
    private void handleDeleteTask() {
        int selectedIndex = taskTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            taskTable.getItems().remove(selectedIndex);
        } else {
            // If nothing selected error out
            errorReport();
        }
    }

    // Alert Error without terminating program
    private void errorReport() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.initOwner(mainApp.getPrimaryStage());
        alert.setTitle("No Selection");
        alert.setHeaderText("No Task Selected");
        alert.setContentText("Please select a person in the table.");

        // Waits for the user to close the error out
        alert.showAndWait();
    }
}