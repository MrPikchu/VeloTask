package model;

import enums.Status;
import enums.Priority;
import java.time.LocalDate;

public class Task {
    private int id;
    private String title;
    private Status status;
    private Priority priority;
    private LocalDate deadline;

    public Task(int id, String title) {
        this.id = id;
        this.title = title;
        this.status = Status.TODO;
        this.priority = Priority.MEDIUM;
    }


    public int getId() { return id; }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String toString() {
        return id + " | " + title + " | " + status + " | " + priority;
    }
}
