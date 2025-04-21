public class DoublyLinkedList {
    class Node {
        int data;
        Node prev, next;
        Node(int data) { this.data = data; }
    }
    Node head, tail;

    public void insertAtEnd(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void delete(int data) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == data) {
                if (curr.prev != null) curr.prev.next = curr.next;
                else head = curr.next;
                if (curr.next != null) curr.next.prev = curr.prev;
                else tail = curr.prev;
                return;
            }
            curr = curr.next;
        }
    }

    public void display() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " <-> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtEnd(1);
        dll.insertAtEnd(2);
        dll.insertAtEnd(3);
        dll.display();
        dll.delete(2);
        dll.display();
    }
}
