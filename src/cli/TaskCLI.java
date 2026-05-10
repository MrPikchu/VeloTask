package cli;
import model.Task;
import util.ChatUtil;
import util.SleepUtil;
import enums.Priority;
import service.TaskService;
import enums.Status;

import java.util.List;
import java.util.Scanner;

public class TaskCLI {

    private TaskService service;
    private Scanner scanner = new Scanner(System.in);


    public TaskCLI(TaskService service) {
        this.service = service;
    }

    public void start() {

        ChatUtil.log("Witaj w programie VeloTask, autorstwa : MrPikchu (https://github.com/MrPikchu)");
        SleepUtil.wait(3000);

        while (true) {
            ChatUtil.log("=== VeloTask ===");
            ChatUtil.log("1) Nowe zadanie");
            SleepUtil.wait(250);
            ChatUtil.log("2) Zmiana statusu");
            SleepUtil.wait(250);
            ChatUtil.log("3) Zmiana priority");
            SleepUtil.wait(250);
            ChatUtil.log("4) Lista zadań");
            SleepUtil.wait(250);
            ChatUtil.log("5) Usuń zadanie");
            SleepUtil.wait(250);
            ChatUtil.log("0) Wyjście");
            SleepUtil.wait(1000);

            ChatUtil.login("Wisz swoja odpowiedz : ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> createTask();
                case 2 -> changeStatus();
                case 3 -> changePriority();
                case 4 -> showTasks();
                case 5 -> deleteTask();
                case 0 -> System.exit(0);
            }
        }
    }

    private void createTask() {
        ChatUtil.login("Tytuł zadania: ");
        String title = scanner.nextLine();

        ChatUtil.login("Opis zadania: ");
        String description = scanner.nextLine();

        Task task = service.createTask(title, description);

        ChatUtil.log("Zadanie zostało stworzone");
        SleepUtil.wait(2000);
        ChatUtil.log("ID zadania : "+ task.getId());
        SleepUtil.wait(250);
        ChatUtil.log("Tytuł zadania : "+ task.getTitle());
        SleepUtil.wait(250);
        ChatUtil.log("Opis zadania : "+ task.getDescription());
        SleepUtil.wait(2000);

    }

    private void changeStatus() {
        ChatUtil.login("Podaj ID zadania: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Task task = service.getTaskById(id);

        if (task == null) {
            ChatUtil.log("Nie znaleziono zadania o ID: " + id);
            SleepUtil.wait(1500);
            return;
        }

        ChatUtil.log("Znaleziono zadanie: " + task.getTitle());
        SleepUtil.wait(500);

        ChatUtil.login("1) Do zrobienia 2) W trakcie 3) Zrobione: ");
        int stat = scanner.nextInt();
        scanner.nextLine();

        Status status = switch (stat) {
            case 1 -> Status.TODO;
            case 2 -> Status.IN_PROGRESS;
            case 3 -> Status.DONE;
            default -> Status.TODO;
        };

        if (service.changeStatus(id, status)) {
            ChatUtil.log("Status został zmieniony!");
        } else {
            ChatUtil.log("Cos poszlo nie tak!");
        }
        SleepUtil.wait(1500);
    }

    private void showTasks() {
        List<Task> tasks = service.getAllTasks();

        if (tasks.isEmpty()) {
            ChatUtil.log("Brak zadań!");
            SleepUtil.wait(1500);
            return;
        }

        ChatUtil.log("=== Lista zadań ===");
        for (Task task : tasks) {
            ChatUtil.log(task.toString());
            SleepUtil.wait(200);
        }
        ChatUtil.log("===================");
    }

    private void changePriority() {
        ChatUtil.login("Podaj ID zadania: ");
        int id = scanner.nextInt();


        Task task = service.getTaskById(id);

        if (task == null) {
            ChatUtil.log("Nie znaleziono zadania o ID: " + id);
            SleepUtil.wait(1500);
            return;
        }

        ChatUtil.log("Znaleziono zadanie: " + task.getTitle());
        SleepUtil.wait(500);

        ChatUtil.log("1) NISKIE 2) ŚRENIDE 3) WYSOKIE");
        int prio = scanner.nextInt();

        Priority priority = switch (prio) {
          case 1 -> Priority.LOW;
          case 2 -> Priority.MEDIUM;
          case 3 -> Priority.HIGH;
          default -> Priority.MEDIUM;
        };

        if (service.changePriority(id, priority)) {
            ChatUtil.log("Zmieniono pomyślnie priorytet zadania!");
        } else {
            ChatUtil.log("Nie znaleziono zadania o ID: "+id);
        }

        SleepUtil.wait(1500);
    }


    private void deleteTask() {
        ChatUtil.login("Podaj ID zadania do usunięcia : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean usunieto = service.deleteTask(id);

        if (usunieto) {
            ChatUtil.log("Zadanie usunięto poprawnie !");
        } else {
            ChatUtil.log("Nie znaleziono zadania o ID: "+id);
        }
        SleepUtil.wait(1500);
    }
}