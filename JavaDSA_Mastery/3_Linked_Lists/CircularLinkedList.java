public class CircularLinkedList {
    class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }
    Node head = null;

    public void insert(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            node.next = head;
        } else {
            Node curr = head;
            while (curr.next != head) curr = curr.next;
            curr.next = node;
            node.next = head;
        }
    }

    public void display() {
        if (head == null) return;
        Node curr = head;
        do {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        } while (curr != head);
        System.out.println("(head)");
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.insert(10);
        cll.insert(20);
        cll.insert(30);
        cll.display();
    }
}
