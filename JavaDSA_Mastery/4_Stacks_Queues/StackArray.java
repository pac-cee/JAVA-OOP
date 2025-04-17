public class StackArray {
    private int maxSize;
    private int[] stack;
    private int top;
    public StackArray(int size) {
        maxSize = size;
        stack = new int[maxSize];
        top = -1;
    }
    public void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = value;
    }
    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top--];
    }
    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top];
    }
    public static void main(String[] args) {
        StackArray s = new StackArray(3);
        s.push(10); s.push(20); s.push(30);
        System.out.println(s.pop()); // 30
        System.out.println(s.peek()); // 20
    }
}
