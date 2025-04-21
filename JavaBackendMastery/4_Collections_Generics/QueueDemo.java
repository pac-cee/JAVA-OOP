import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Queue: " + queue);
        System.out.println("Polling: " + queue.poll()); // Removes 10
        System.out.println("Queue after poll: " + queue);
        System.out.println("Peek: " + queue.peek());   // Shows 20
    }
}
