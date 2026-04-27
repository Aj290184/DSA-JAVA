import java.util.*;

class CopyListRandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node copyRandomList(Node head){
        if(head == null) return null;
        HashMap<Node, Node> map = new HashMap<>();

        Node temp = head;
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            Node copy = map.get(temp);
            copy.next = map.get(temp.next);
            copy.random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(head);
    }

    public static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            int randomVal = (temp.random != null) ? temp.random.val : -1;
            System.out.println(
                "Node: " + temp.val + 
                " | Next: " + (temp.next != null ? temp.next.val : "null") + 
                " | Random: " + (randomVal != -1 ? randomVal : "null")
            );
            temp = temp.next;
        }
    }

    // 🔥 Check deep copy (VERY IMPORTANT)
    public static void verifyDeepCopy(Node original, Node copy) {
        Node t1 = original;
        Node t2 = copy;

        while (t1 != null && t2 != null) {
            if (t1 == t2) {
                System.out.println("❌ Not a deep copy (same reference)");
                return;
            }
            if (t1.val != t2.val) {
                System.out.println("❌ Values mismatch");
                return;
            }
            t1 = t1.next;
            t2 = t2.next;
        }

        System.out.println("✅ Deep copy verified (different nodes, same values)");
    }

    public static void main(String[] args) {

        // Build list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        // Random pointers
        head.random = head.next;           // 1 → 2
        head.next.random = head;           // 2 → 1
        head.next.next.random = head;      // 3 → 1

        System.out.println("Original List:");
        printList(head);

        Node copy = copyRandomList(head);

        System.out.println("\nCopied List:");
        printList(copy);

        System.out.println("\nVerification:");
        verifyDeepCopy(head, copy);
    }
}