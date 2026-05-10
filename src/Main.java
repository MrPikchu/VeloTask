import cli.TaskCLI;
import repository.TaskRepository;
import service.TaskService;

public class Main {
    public static void main(String[] args) {

        TaskRepository repo = new TaskRepository();
        TaskService service = new TaskService(repo);
        TaskCLI cli = new TaskCLI(service);

        cli.start();
    }
}