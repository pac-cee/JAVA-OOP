public class Deque {
    int[] arr;
    int front, rear, size, capacity;

    public Deque(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = -1;
        rear = 0;
        size = 0;
    }

    public boolean isFull() { return size == capacity; }
    public boolean isEmpty() { return size == 0; }

    public void insertFront(int data) {
        if (isFull()) throw new RuntimeException("Deque Overflow");
        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (front == 0) {
            front = capacity - 1;
        } else {
            front--;
        }
        arr[front] = data;
        size++;
    }

    public void insertRear(int data) {
        if (isFull()) throw new RuntimeException("Deque Overflow");
        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (rear == capacity - 1) {
            rear = 0;
        } else {
            rear++;
        }
        arr[rear] = data;
        size++;
    }

    public int deleteFront() {
        if (isEmpty()) throw new RuntimeException("Deque Underflow");
        int val = arr[front];
        if (front == rear) {
            front = -1;
            rear = 0;
        } else if (front == capacity - 1) {
            front = 0;
        } else {
            front++;
        }
        size--;
        return val;
    }

    public int deleteRear() {
        if (isEmpty()) throw new RuntimeException("Deque Underflow");
        int val = arr[rear];
        if (front == rear) {
            front = -1;
            rear = 0;
        } else if (rear == 0) {
            rear = capacity - 1;
        } else {
            rear--;
        }
        size--;
        return val;
    }

    public void display() {
        if (isEmpty()) { System.out.println("Deque is empty"); return; }
        int count = 0, i = front;
        while (count < size) {
            System.out.print(arr[i] + " <-> ");
            i = (i + 1) % capacity;
            count++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Deque deque = new Deque(5);
        deque.insertRear(10);
        deque.insertFront(20);
        deque.insertRear(30);
        deque.display();
        System.out.println("Delete Front: " + deque.deleteFront());
        deque.display();
    }
}
