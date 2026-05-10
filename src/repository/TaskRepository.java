package repository;

import model.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public Task save(String title, String description) {
        Task task = new Task(nextId++, title, description);
        tasks.add(task);
        return task;
    }

    public List<Task> findAll() {
        return tasks;
    }

    public Task findById(int id) {
        return tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean delete(int id) {
        return tasks.removeIf(t -> t.getId() == id);
    }
}