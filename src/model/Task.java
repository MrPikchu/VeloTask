package model;

import enums.Status;
import enums.Priority;
import java.time.LocalDate;

public class Task {
    private int id;
    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private LocalDate deadline;

    public Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = Status.TODO;
        this.priority = Priority.MEDIUM;
    }


    public int getId() { return id; }

    public String getTitle() {return title; }

    public String getDescription() {return description; }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String toString() {
        return id + " | " + title + " | "+ description + " | " + status + " | " + priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
