public class LinkedListOperations {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }
    Node head;

    // Insert at beginning
    public void insertAtBeginning(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    // Delete by value
    public void delete(int data) {
        if (head == null) return;
        if (head.data == data) { head = head.next; return; }
        Node curr = head;
        while (curr.next != null) {
            if (curr.next.data == data) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }

    // Search for value
    public boolean search(int data) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == data) return true;
            curr = curr.next;
        }
        return false;
    }

    // Reverse the list
    public void reverse() {
        Node prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void display() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedListOperations list = new LinkedListOperations();
        list.insertAtBeginning(5);
        list.insertAtBeginning(10);
        list.insertAtBeginning(15);
        list.display();
        list.delete(10);
        list.display();
        System.out.println("Search 5: " + list.search(5));
        list.reverse();
        list.display();
    }
}
