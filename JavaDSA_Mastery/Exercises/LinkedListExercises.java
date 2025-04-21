public class LinkedListExercises {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }
    Node head;

    // Count nodes
    public int countNodes() {
        int count = 0;
        Node curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
    // Find middle node
    public int findMiddle() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow != null ? slow.data : -1;
    }
    public void insert(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }
    public static void main(String[] args) {
        LinkedListExercises list = new LinkedListExercises();
        list.insert(1); list.insert(2); list.insert(3); list.insert(4); list.insert(5);
        System.out.println("Node count: " + list.countNodes());
        System.out.println("Middle node: " + list.findMiddle());
    }
}
