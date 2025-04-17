class Node {
    int data;
    Node next;
    Node(int data) { this.data = data; }
}

public class SinglyLinkedList {
    Node head;
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
    }
    public void remove(int data) {
        if (head == null) return;
        if (head.data == data) { head = head.next; return; }
        Node temp = head;
        while (temp.next != null && temp.next.data != data) temp = temp.next;
        if (temp.next != null) temp.next = temp.next.next;
    }
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1); list.add(2); list.add(3);
        list.printList(); // Output: 1 2 3
        list.remove(2);
        list.printList(); // Output: 1 3
    }
}
