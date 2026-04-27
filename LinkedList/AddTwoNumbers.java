class AddTwoNumbers {

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

    public ListNode addTwoNumbers(ListNode list1, ListNode list2){
        list1 = reverseList(list1);
        list2 = reverseList(list2);

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int carry = 0;

        while (list1 != null || list2 != null || carry != 0) {
            int sum = carry;

            if(list1 != null){
                sum += list1.val;
                list1 = list1.next;
            }

            if(list2 != null){
                sum += list2.val;
                list2 = list2.next;
            }

            temp.next = new ListNode(sum % 10);
            carry = sum / 10;

            temp = temp.next;
        }

        return reverseList(dummy.next);
    }

    public static void main(String[] args) {
        AddTwoNumbers obj = new AddTwoNumbers();

        ListNode lis1 = new ListNode(2);
        lis1.next = new ListNode(4);
        lis1.next.next = new ListNode(3);

        ListNode lis2 = new ListNode(5);
        lis2.next = new ListNode(6);
        lis2.next.next = new ListNode(4);

        System.out.print("List 1 : ");
        print(lis1);

        System.out.print("List 2 : ");
        print(lis2);

        ListNode result = obj.addTwoNumbers(lis1, lis2);

        System.out.print("Result : ");
        print(result);
    }
}