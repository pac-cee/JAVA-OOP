// Implements a stack using an array
public class StackDemo {
    private int[] stack;
    private int top;
    public StackDemo(int size) {
        stack = new int[size];
        top = -1;
    }
    public void push(int val) {
        if (top == stack.length - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = val;
    }
    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top--];
    }
    public static void main(String[] args) {
        StackDemo s = new StackDemo(3);
        s.push(10); s.push(20); s.push(30);
        System.out.println(s.pop()); // 30
        System.out.println(s.pop()); // 20
    }
}
