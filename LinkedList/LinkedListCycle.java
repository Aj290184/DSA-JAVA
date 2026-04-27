class LinkedListCycle {
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

    public boolean hasCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
    }
    
    public static void main(String[] args) {

        LinkedListCycle obj = new LinkedListCycle();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3); 
        head.next.next.next = new ListNode(4); 
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next;

        boolean result = obj.hasCycle(head);

        System.out.println("Cycle present : " + result);
    }
}