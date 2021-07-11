/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Michael Hickey
 */


package ucf.assignments;

import java.time.LocalDate;

import javafx.beans.property.*;

public class Task {

    private final StringProperty taskLabel;
    private final StringProperty description;
    private final ObjectProperty<LocalDate> dueDate;
    private final StringProperty taskCompleted;
    private final BooleanProperty status;
    private String taskStatus;

    // Default Constructor for Task
    public Task() {
        this(null, null);
    }

    // Constructor
    public Task (String taskLabel, String description) {
        this.taskLabel = new SimpleStringProperty(taskLabel);
        this.description = new SimpleStringProperty(description);
        this.dueDate = new SimpleObjectProperty<>();
        this.status = new SimpleBooleanProperty();
        this.taskStatus = new String();
        this.taskCompleted = new SimpleStringProperty();

    }

    // Setters and Getters
    public String getTaskLabel() {
        return taskLabel.get();
    }

    public void setTaskLabel(String taskLabel) {
        this.taskLabel.set(taskLabel);
    }

    public StringProperty taskLabelProperty() {
        return taskLabel;
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public LocalDate getDueDate() {
        return dueDate.get();
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate.set(dueDate);
    }

    public void setTaskCompleted(String taskCompleted) {
        this.taskCompleted.set(taskCompleted);
    }

    public StringProperty taskCompletedColumnProperty() {
        return taskCompleted;
    }

    public Boolean getStatus() {
        return status.get();
    }

    public void setStatus(Boolean status) {
        this.status.set(status);
    }

    public String getTaskStatus() {
        if(this.getStatus()) {
            this.taskStatus = "Completed";
        }
        else
        {
            this.taskStatus = "Incomplete";
        }
        return taskStatus;
    }
}