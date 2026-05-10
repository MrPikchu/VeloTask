package cli;

import service.TaskService;
import enums.Status;

import java.util.Scanner;

public class TaskCLI {

    private TaskService service = new TaskService();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("Witaj w programie VeloTask, autorstwa : MrPikchu (https://github.com/MrPikchu");
            System.out.println("=== VeloTask ===");
            System.out.println("1) Nowe zadanie");
            System.out.println("2) Zmiana statusu");
            System.out.println("3) Lista zadań");
            System.out.println("0) Wyjście");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> createTask();
                case 2 -> changeStatus();
                case 3 -> showTasks();
                case 0 -> System.exit(0);
            }
        }
    }

    private void createTask() {
        System.out.print("Tytuł: ");
        String title = scanner.nextLine();
        service.createTask(title);
    }

    private void changeStatus() {
        System.out.print("ID: ");
        int id = scanner.nextInt();

        System.out.println("1) TODO 2) IN_PROGRESS 3) DONE");
        int s = scanner.nextInt();

        Status status = switch (s) {
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
}