import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;

public class Linkedlist {
    Node head;
    Queue completedQueue = new Queue();
    Stack urgenttack = new Stack();
    HashMap<String, LinkedList<Node>> categoryMap = new HashMap<>();
    public Linkedlist(){
        head = null;
    }
    boolean isEmpty() {
        return head == null;
    }
   public void addNode(String name, Date dueDate, boolean priority, String category) {
        Node newNode = new Node(name, dueDate, priority, category);
        if (newNode.getPriority() == true){
            urgenttack.push(newNode);
        }
        // If the list is empty or the new node should be the first node
        if (isEmpty() || head.dueDate.compareTo(dueDate) > 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        // Find the correct position to insert the new node
        Node current = head;
        while (current.next != null && current.next.dueDate.compareTo(dueDate) <= 0) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
        // Add to the category-based list
        if (!categoryMap.containsKey(category)) {
            categoryMap.put(category, new LinkedList<>());
        }
        categoryMap.get(category).add(newNode);
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
        if (urgenttack.isEmpty()) {
            System.out.println("No urgent tasks");
            return;
        }
        Node current = urgenttack.head;
        while (current != null) {
            System.out.println("Task: " + current.name + ", Due Date: " + current.dueDate +
                               ", Priority: " + (current.priority ? "Urgent" : "Normal") +
                               ", Category: " + current.category);
            current = current.next;
        }
    }
    public void printTasksByCategory() {
        if (categoryMap.isEmpty()) {
            System.out.println("No tasks available");
            return;
        }
        for (String category : categoryMap.keySet()) {
            System.out.println("Category: " + category);
            for (Node task : categoryMap.get(category)) {
                System.out.println("    Task: " + task.name + ", Due Date: " + task.dueDate +
                                   ", Priority: " + (task.priority ? "Urgent" : "Normal") +
                                   ", Category: " + task.category);
            }
        }
    }
     public void printLL(){
          if(isEmpty()) {
            System.out.println("LL is empty");
            return;
        }
        Node current = head;
        while(current != null){
            System.out.println(current.name);
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
        if(head.next != null) {
            head = head.next;
            return;
        }
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
        Node current= head;
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
        if (head.name == name) {
            head = head.next;
            return;
        }
// Method 2 without using prev
        Node current = head;

        while (current != null && current.next.name != name) {
            current = current.next;
        }
        if (current == null) {
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
}
