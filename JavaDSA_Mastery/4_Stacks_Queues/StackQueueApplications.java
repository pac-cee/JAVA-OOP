import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class StackQueueApplications {
    // Parenthesis checker using Stack
    public static boolean isBalanced(String expr) {
        Stack<Character> stack = new Stack<>();
        for (char c : expr.toCharArray()) {
            if (c == '(') stack.push(c);
            else if (c == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    // Reverse a queue using Stack
    public static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) stack.push(queue.remove());
        while (!stack.isEmpty()) queue.add(stack.pop());
    }

    public static void main(String[] args) {
        // Parenthesis Checker
        String expr = "((()))()";
        System.out.println("Is balanced: " + isBalanced(expr));

        // Reverse Queue
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1); queue.add(2); queue.add(3);
        System.out.println("Original queue: " + queue);
        reverseQueue(queue);
        System.out.println("Reversed queue: " + queue);
    }
}
