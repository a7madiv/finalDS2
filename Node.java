import java.sql.Date;

public class Node {
    String name;
    Date dueDate;
    boolean priority;
    String category;
    Node next;

    public Node(String name, Date dueDate, boolean priority, String category) {
        this.name = name;
        this.dueDate = dueDate;
        this.priority = priority;
        this.category = category;
        this.next = null;
    }

    public String getName() {
        return name;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public boolean getPriority() {
        return priority;
    }

    public String getCategory() {
        return category;
    }
}
