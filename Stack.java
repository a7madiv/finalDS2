public class Stack {
    Node head;
    Node top;
    public Stack(){
        this.head = null;
        this.top = null;
    }
    void push(Node newNode){
        if(isEmpty()) {
            head =top= newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
        if(top==null){
            top=head;
        }
    }
    boolean isEmpty() {
        return head == null;
    }
}
