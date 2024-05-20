public class Stack {
    Node head;

    public Stack() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(Node node) {
        node.next = head;
        head = node;
    }

    public Node pop() {
        if (isEmpty()) {
            return null;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }
}
