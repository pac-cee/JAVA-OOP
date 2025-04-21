public class QueueArray {
    int[] arr;
    int front, rear, size, capacity;

    public QueueArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int data) {
        if (size == capacity) throw new RuntimeException("Queue Overflow");
        rear = (rear + 1) % capacity;
        arr[rear] = data;
        size++;
    }

    public int dequeue() {
        if (size == 0) throw new RuntimeException("Queue Underflow");
        int val = arr[front];
        front = (front + 1) % capacity;
        size--;
        return val;
    }

    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == capacity; }

    public void display() {
        if (size == 0) { System.out.println("Queue is empty"); return; }
        int count = 0, i = front;
        while (count < size) {
            System.out.print(arr[i] + " <- ");
            i = (i + 1) % capacity;
            count++;
        }
        System.out.println("rear");
    }

    public static void main(String[] args) {
        QueueArray queue = new QueueArray(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.display();
        System.out.println("Dequeue: " + queue.dequeue());
        queue.display();
    }
}
