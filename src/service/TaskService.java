package service;

import enums.Priority;
import enums.Status;
import model.Task;
import repository.TaskRepository;

import java.util.List;

public class TaskService {

    private final TaskRepository repo;


    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }


    public Task createTask(String title, String description) {
        return repo.save(title, description);
    }


    public List<Task> getAllTasks() {
        return repo.findAll();
    }

    public Task getTaskById(int id) {
        return repo.findById(id);
    }


    public void changeStatus(int id, Status status) {
        Task task = repo.findById(id);
        if (task != null) {
            task.setStatus(status);
        }
    }


    public void changePriority(int id, Priority priority) {
        Task task = repo.findById(id);
        if (task != null) {
            task.setPriority(priority);
        }
    }
}