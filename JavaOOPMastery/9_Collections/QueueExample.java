import java.util.*;
public class QueueExample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("First");
        queue.add("Second");
        queue.add("Third");
        System.out.println("Queue: " + queue);
        queue.remove();
        System.out.println("After removal: " + queue);
    }
}
