import java.sql.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Linkedlist taskList = new Linkedlist();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add a task");
            System.out.println("2. Complete a task");
            System.out.println("3. View all tasks");
            System.out.println("4. View completed tasks");
            System.out.println("5. View urgent tasks");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter task name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter due date (yyyy-mm-dd):");
                    Date dueDate = Date.valueOf(scanner.nextLine());
                    System.out.println("Enter priority (true for urgent, false for normal):");
                    boolean priority = scanner.nextBoolean();
                    scanner.nextLine(); // consume newline
                    System.out.println("Enter category:");
                    String category = scanner.nextLine();
                    taskList.addNode(name, dueDate, priority, category);
                    break;
                case 2:
                    System.out.println("Enter the name of the task to complete:");
                    String taskName = scanner.nextLine();
                    taskList.completeTask(taskName);
                    break;
                case 3:
                    System.out.println("All tasks:");
                    taskList.printLL();
                    break;
                case 4:
                    System.out.println("Completed tasks:");
                    taskList.printCompletedTasks();
                    break;
                case 5:
                    System.out.println("Urgent tasks:");
                    taskList.printUrgentTasks();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
