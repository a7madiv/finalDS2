import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Linkedlist {
    Node head;
    Queue completedQueue = new Queue();
    Stack urgentStack = new Stack();

    public Linkedlist(){
        head = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    public void addNode(String name, Date dueDate, boolean priority, String category) {
        Node newNode = new Node(name, dueDate, priority, category);
        if (isEmpty() || head.dueDate.compareTo(dueDate) > 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.dueDate.compareTo(dueDate) <= 0) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    public void completeTask(String name) {
        if (isEmpty()) {
            System.out.println("Task not found");
            return;
        }

        if (head.name.equals(name)) {
            Node completedNode = head;
            head = head.next;
            completedNode.next = null; // Clear the next pointer
            completedQueue.enqueue(completedNode);
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.name.equals(name)) {
                Node completedNode = current.next;
                current.next = current.next.next;
                completedNode.next = null; // Clear the next pointer
                completedQueue.enqueue(completedNode);
                return;
            }
            current = current.next;
        }

        System.out.println("Task not found");
    }

    public void printCompletedTasks() {
        if (completedQueue.isEmpty()) {
            System.out.println("No completed tasks");
            return;
        }
        Node current = completedQueue.head;
        while (current != null) {
            System.out.println("Task: " + current.name + ", Due Date: " + current.dueDate +
                               ", Priority: " + (current.priority ? "Urgent" : "Normal") +
                               ", Category: " + current.category);
            current = current.next;
        }
    }

    public void printUrgentTasks() {
        if (urgentStack.isEmpty()) {
            System.out.println("No urgent tasks");
            return;
        }
        Node current = urgentStack.head;
        while (current != null) {
            System.out.println("Task: " + current.name + ", Due Date: " + current.dueDate +
                               ", Priority: " + (current.priority ? "Urgent" : "Normal") +
                               ", Category: " + current.category);
            current = current.next;
        }
    }

    public void printLL() {
        if(isEmpty()) {
            System.out.println("LL is empty");
            return;
        }
        Node current = head;
        while(current != null){
            System.out.println(current.name + ", Due Date: " + current.dueDate + ", Priority: " + (current.priority ? "Urgent" : "Normal") + ", Category: " + current.category);
            current = current.next;
        }
    }

    public void removeFirst() {
        if(isEmpty()) {
            System.out.println("LL is empty");
            return;
        }
        if(head.next == null) {
            head = null;
            return;
        }
        head = head.next;
    }

    public void removeLast() {
        if(isEmpty()) {
            System.out.println("LL is empty");
            return;
        }
        if(head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    public void removeElement(String name) {
        if(isEmpty()) {
            System.out.println("LL is empty");
            return;
        }
        if (head.name.equals(name)) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current != null && current.next != null && !current.next.name.equals(name)) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            System.out.println("LL doesn't have this value");
            return;
        }
        current.next = current.next.next;
    }

    public Node getHead() {
        if(isEmpty()) {
            return null;
        }
        return head;
    }

    public void copyUrgentTasksToStack() {
        if (isEmpty()) {
            System.out.println("No tasks in the list");
            return;
        }
        Node current = head;
        while (current != null) {
            if (current.priority) {
                urgentStack.push(new Node(current.name, current.dueDate, current.priority, current.category));
            }
            current = current.next;
        }
    }
     public ArrayList<Node> copyAndSortByCategory() {
        ArrayList<Node> taskList = new ArrayList<>();
        Node current = head;
        while (current != null) {
            taskList.add(new Node(current.name, current.dueDate, current.priority, current.category));
            current = current.next;
        }

        Collections.sort(taskList, new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.category.compareTo(n2.category);
            }
        });

        return taskList;
    }
}
