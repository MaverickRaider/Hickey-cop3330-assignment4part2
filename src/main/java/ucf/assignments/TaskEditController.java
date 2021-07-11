/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Michael Hickey
 */


package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TaskEditController {

    @FXML
    private TextField taskNameField;
    @FXML
    private TextArea descriptionArea;
    @FXML
    private TextField dueDateField;
    @FXML
    private CheckBox statusComplete;

    private Stage dialogStage;
    private Task task;
    private boolean okClicked = false;


    // Initializes the controller class
    @FXML
    private void initialize() {
    }

    // Sets the stage of this dialog
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    // Sets the task to be edited in the dialog.
    public void setTask(Task task) {
        this.task = task;

        taskNameField.setText(task.getTaskLabel());
        descriptionArea.setText(task.getDescription());
        descriptionArea.setPromptText("256 Characters Max");
        dueDateField.setText(DateUtil.format(task.getDueDate()));
        dueDateField.setPromptText("YYYY-MM-DD");
        statusComplete.setSelected(task.getStatus());
    }

    // Checks to see if the OK button was clicked
    public boolean isOkClicked() {
        return okClicked;
    }

    // Once OK is clicked, then set the data in the task.
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            task.setTaskLabel(taskNameField.getText());
            task.setDescription(descriptionArea.getText());
            task.setDueDate(DateUtil.parse(dueDateField.getText()));
            task.setStatus(statusComplete.isSelected());
            if(statusComplete.isSelected())
            {
                task.setTaskCompleted("Completed");
            }
            else {
                task.setTaskCompleted("Incomplete");
            }

            okClicked = true;
            dialogStage.close();
        }
    }

    // Closes the dialog if cancel is clicked
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    // Input Validation
    private boolean isInputValid() {
        String errorMessage = "";

        if (taskNameField.getText() == null || taskNameField.getText().length() == 0) {
            errorMessage += "Invalid title!\n";
        }
        if (descriptionArea.getText() == null || descriptionArea.getText().length() == 0) {
            errorMessage += "Invalid description!\n";
        }
        if (descriptionArea.getText().length() > 256) {
            errorMessage += "Max Characters Reached " + descriptionArea.getText().length() + "/256\n";
        }
        if (dueDateField.getText() == null || dueDateField.getText().length() == 0) {
            errorMessage += "Invalid Date!\n";
        } else {
            if (!DateUtil.validDate(dueDateField.getText())) {
                errorMessage += "Invalid date. Use the format YYYY-MM-DD!\n";
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}