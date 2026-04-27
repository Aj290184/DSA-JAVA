class PalindromeLL {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public boolean palindrome(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        ListNode first = head;
        ListNode second = prev;

        while (second != null) {
            if(first.val != second.val){
                return false;
            }

            first = first.next;
            second = second.next;
        }

        return true;
    }

    public static void print(ListNode head){
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("Null");
    }

    public static void main(String[] args) {
        PalindromeLL obj = new PalindromeLL();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2); 
        head.next.next.next = new ListNode(1); 

        print(head);

        boolean result = obj.palindrome(head);

        System.out.println("Is Palindrome : " + result);
    }
}