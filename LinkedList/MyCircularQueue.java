class MyCircularQueue {
    int[] arr;
    int front, rear, size, capacity;

    public MyCircularQueue(int k){
        capacity = k;
        arr = new int[k];
        front = 0;
        rear = 0;
        size = 0;
    }

    public boolean enQueue(int value){
        if(isFull()) return false;

        arr[rear] = value;
        rear = (rear + 1) & capacity;
        size++;
        return true;
    }

    public boolean deQueue(){
        if(isEmpty()) return false;

        front = (front + 1) % capacity;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    public int Rear(){
        if(isEmpty()) return -1;
        return arr[(rear - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void printQueue() {
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(arr[index] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        MyCircularQueue q = new MyCircularQueue(3);

        System.out.println(q.enQueue(1));
        System.out.println(q.enQueue(2));
        System.out.println(q.enQueue(3));
        System.out.println(q.enQueue(4));

        q.printQueue();

        System.out.println("Rear: " + q.Rear());   
        System.out.println("Is Full: " + q.isFull());

        System.out.println(q.deQueue());
        q.printQueue();

        System.out.println(q.enQueue(4));
        q.printQueue();

        System.out.println("Front: " + q.Front()); 
        System.out.println("Rear: " + q.Rear());
    }
}