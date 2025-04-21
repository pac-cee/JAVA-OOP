// Practice Problem: Implement a Stack with Java Generics
import java.util.LinkedList;

public class PracticeProblem2<T> {
    private LinkedList<T> stack = new LinkedList<>();
    public void push(T value) { stack.addFirst(value); }
    public T pop() { return stack.isEmpty() ? null : stack.removeFirst(); }
    public T peek() { return stack.isEmpty() ? null : stack.getFirst(); }
    public boolean isEmpty() { return stack.isEmpty(); }
    public int size() { return stack.size(); }

    public static void main(String[] args) {
        PracticeProblem2<Integer> intStack = new PracticeProblem2<>();
        intStack.push(10);
        intStack.push(20);
        System.out.println("Top: " + intStack.peek()); // 20
        System.out.println("Pop: " + intStack.pop()); // 20
        System.out.println("Is Empty: " + intStack.isEmpty()); // false
    }
}
