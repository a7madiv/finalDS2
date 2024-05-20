import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Linkedlist taskList = new Linkedlist();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add a task");
            System.out.println("2. Complete a task");
            System.out.println("3. Print all tasks");
            System.out.println("4. Print urgent tasks");
            System.out.println("5. Print completed tasks");
            System.out.println("6. Copy and sort tasks by category");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter due date (yyyy-mm-dd): ");
                    String dueDateString = scanner.nextLine();
                    Date dueDate = Date.valueOf(dueDateString);
                    System.out.print("Is it an urgent task? (true/false): ");
                    boolean priority = scanner.nextBoolean();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter task category: ");
                    String category = scanner.nextLine();

                    taskList.addNode(name, dueDate, priority, category);
                    System.out.println("Task added successfully!");
                    break;

                case 2:
                    System.out.print("Enter the name of the task to complete: ");
                    String taskNameToComplete = scanner.nextLine();
                    taskList.completeTask(taskNameToComplete);
                    System.out.println("Task marked as completed!");
                    break;

                case 3:
                    System.out.println("All tasks in the linked list:");
                    taskList.printLL();
                    break;

                case 4:
                    taskList.copyUrgentTasksToStack();
                    System.out.println("Urgent tasks in the stack:");
                    taskList.printUrgentTasks();
                    break;

                case 5:
                    System.out.println("Completed tasks:");
                    taskList.printCompletedTasks();
                    break;

                case 6:
                    ArrayList<Node> sortedTasks = taskList.copyAndSortByCategory();
                    System.out.println("Tasks sorted by category in the ArrayList:");
                    for (Node task : sortedTasks) {
                        System.out.println("Task: " + task.name + ", Due Date: " + task.dueDate +
                                ", Priority: " + (task.priority ? "Urgent" : "Normal") + ", Category: " + task.category);
                    }
                    break;

                case 7:
                    System.out.println("Exiting the application...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
