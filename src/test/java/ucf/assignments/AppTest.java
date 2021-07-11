package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void getTaskData() {
        ObservableList<Task> taskData = FXCollections.observableArrayList();
        taskData.add(new Task("Get Milk", "Get milk from publix"));
        taskData.add(new Task("Finish Coding", "Work on problem 2"));
    }

    @Test
    void initRootLayout() {
        try {
            BorderPane rootLayout;

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("RootLayout.fxml"));
            rootLayout = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void showApp() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("App.fxml"));
            AnchorPane appOverview = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void showTaskEditor() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("TaskEditor.fxml"));
            AnchorPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Task");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}