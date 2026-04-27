class MiddleLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public ListNode middle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void print(ListNode head){
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        MiddleLinkedList obj = new MiddleLinkedList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3); 
        head.next.next.next = new ListNode(4); 
        head.next.next.next.next = new ListNode(5);

        System.out.print("List : ");
        print(head);

        ListNode mid = obj.middle(head);

        System.out.println("Middle Node : " + mid.val);
    }
}