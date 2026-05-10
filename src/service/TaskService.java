package service;

import repository.TaskRepository;
import model.Task;
import enums.Status;

import java.util.List;

public class TaskService {

    private TaskRepository repo = new TaskRepository();

    public void createTask(String title) {
        repo.save(title);
    }

    public List<Task> getAllTasks() {
        return repo.findAll();
    }

    public void changeStatus(int id, Status status) {
        Task task = repo.findById(id);
        if (task != null) {
            task.setStatus(status);
        }
    }
}