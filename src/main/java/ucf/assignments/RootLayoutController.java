package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class RootLayoutController {

    // Reference to the main application
    private App mainApp;

    public void setMainApp(App mainApp) {
        this.mainApp = mainApp;
    }

    // New clicked in the menu
    @FXML
    private void handleNew() {
        mainApp.getTaskData().clear();
    }

    // Open clicked in the menu
    @FXML
    private void handleOpen() {
        /**
         * open from file
         */
    }

    // Save clicked in the menu
    @FXML
    private void handleSave() {
        /**
         * save to file
         * like Saveas
         */
    }

    // About clicked
    @FXML
    private void handleAbout() {
        // About opens an alert that has instructions
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Todo List Manager");
        alert.setHeaderText("About");
        alert.setContentText("\n" +
                "'New..' generates a new task.\n" +
                "'Edit...' changes the properties of the task.\n" +
                "'Delete' remove a task off the list.\n\n" +
                "File > New, generates a new List.\n" +
                "File > Save, saves the information externally.\n" +
                "File > Open, opens a new file to be read into the app.\n" +
                "File > Close, closes the program.\n" +
                "Edit > Delete All, deletes the whole list.");
        alert.showAndWait();
    }

    // Quit clicked
    @FXML
    private void handleExit() {
        // when clicked, quit app
        System.exit(0);
    }
}
