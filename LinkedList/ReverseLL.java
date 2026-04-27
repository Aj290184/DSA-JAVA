class ReverseLL {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static void print(ListNode head){
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("Null");
    }

    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ReverseLL obj = new ReverseLL();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3); 
        head.next.next.next = new ListNode(4); 
        head.next.next.next.next = new ListNode(5);
        print(head);
        head = obj.reverseList(head);
        print(head);
    }
}