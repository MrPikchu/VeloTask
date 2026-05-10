package cli;
import model.Task;
import util.ChatUtil;
import util.SleepUtil;
import enums.Priority;
import service.TaskService;
import enums.Status;

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
            ChatUtil.log("2) Zmiana statusu");
            ChatUtil.log("3) Zmiana priority");
            ChatUtil.log("4) Lista zadań");
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
        ChatUtil.log("ID zadania: "+ task.getId());
        ChatUtil.log("Tytuł zadania :"+ task.getTitle());
        ChatUtil.log("Opis zadania :"+ task.getDescription());
        SleepUtil.wait(2000);

    }

    private void changeStatus() {
        ChatUtil.login("Podaj ID zadania: ");
        int id = scanner.nextInt();

        ChatUtil.login("1) Do zrobienia 2) W trakcie 3) Zrobione");
        int stat = scanner.nextInt();

        Status status = switch (stat) {
            case 1 -> Status.TODO;
            case 2 -> Status.IN_PROGRESS;
            case 3 -> Status.DONE;
            default -> Status.TODO;
        };

        service.changeStatus(id, status);
    }

    private void showTasks() {
        service.getAllTasks().forEach(System.out::println);
    }

    private void changePriority() {
        System.out.println("Podaj ID zadania: ");
        int id = scanner.nextInt();

        System.out.println("1) NISKIE 2) ŚRENIDE 3) WYSOKIE");
        int prio = scanner.nextInt();

        Priority priority = switch (prio) {
          case 1 -> Priority.LOW;
          case 2 -> Priority.MEDIUM;
          case 3 -> Priority.HIGH;
          default -> Priority.MEDIUM;
        };

        service.changePriority(id, priority);

    }
}