class Node {
    int data;
    Node next;
    Node(int data) { this.data = data; }
}

public class QueueLinkedList {
    Node front, rear;
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }
    public int dequeue() {
        if (front == null) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int value = front.data;
        front = front.next;
        if (front == null) rear = null;
        return value;
    }
    public static void main(String[] args) {
        QueueLinkedList q = new QueueLinkedList();
        q.enqueue(1); q.enqueue(2); q.enqueue(3);
        System.out.println(q.dequeue()); // 1
        System.out.println(q.dequeue()); // 2
    }
}
