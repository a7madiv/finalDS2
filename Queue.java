public class Queue {
    Node head;
    Node front;

 public Queue(){
    this.head = null;
    this.front = null;
 }
 void enqueue(Node newNode){
    if(isEmpty()) {
            head =front= newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
            front=head;

 }
 boolean isEmpty() {
        return head == null;
    }
}