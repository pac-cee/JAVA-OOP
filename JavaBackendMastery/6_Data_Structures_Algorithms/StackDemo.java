// Implements a stack using an array, with peek and isEmpty methods
public class StackDemo {
    private int[] stack;
    private int top;
    public StackDemo(int size) {
        stack = new int[size];
        top = -1;
    }
    // Push element onto stack
    public void push(int val) {
        if (top == stack.length - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = val;
    }
    // Pop element from stack
    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top--];
    }
    // Peek at top element
    public int peek() {
        if (top == -1) return -1;
        return stack[top];
    }
    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }
    public static void main(String[] args) {
        StackDemo s = new StackDemo(3);
        s.push(10); s.push(20); s.push(30);
        System.out.println("Peek: " + s.peek()); // 30
        System.out.println(s.pop()); // 30
        System.out.println(s.pop()); // 20
        System.out.println("Is empty? " + s.isEmpty()); // false
        s.pop();
        System.out.println("Is empty? " + s.isEmpty()); // true
    }
}

// Implements a queue using an array
class QueueDemo {
    private int[] queue;
    private int front, rear, size;
    public QueueDemo(int capacity) {
        queue = new int[capacity];
        front = 0; rear = -1; size = 0;
    }
    public void enqueue(int val) {
        if (size == queue.length) {
            System.out.println("Queue Overflow");
            return;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = val;
        size++;
    }
    public int dequeue() {
        if (size == 0) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int val = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return val;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public static void main(String[] args) {
        QueueDemo q = new QueueDemo(3);
        q.enqueue(1); q.enqueue(2); q.enqueue(3);
        System.out.println(q.dequeue()); // 1
        System.out.println(q.dequeue()); // 2
        System.out.println("Is empty? " + q.isEmpty()); // false
        q.dequeue();
        System.out.println("Is empty? " + q.isEmpty()); // true
    }
}
