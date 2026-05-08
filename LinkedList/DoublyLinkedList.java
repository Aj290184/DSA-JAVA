public class DoublyLinkedList {

    class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;

    public void insertAtHead(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void insertAtTail(int data) {
        Node newNode = new Node(data);

        if (tail == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void delete(int key) {
        Node curr = head;

        while (curr != null) {
            if (curr.data == key) {

                if (curr == head && curr == tail) {
                    head = tail = null;
                }
                else if (curr == head) {
                    head = head.next;
                    head.prev = null;
                }
                else if (curr == tail) {
                    tail = tail.prev;
                    tail.next = null;
                }
                else {
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                }

                return;
            }
            curr = curr.next;
        }
    }

    public void printForward() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " <-> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public void printBackward() {
        Node curr = tail;
        while (curr != null) {
            System.out.print(curr.data + " <-> ");
            curr = curr.prev;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertAtHead(10);
        dll.insertAtHead(20);
        dll.insertAtTail(30);
        dll.insertAtTail(40);

        dll.printForward();
        dll.printBackward();

        dll.delete(10);
        dll.printForward();
    }
}