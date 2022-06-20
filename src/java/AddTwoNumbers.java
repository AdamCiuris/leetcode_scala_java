package java;

public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode toReturn = new ListNode(0);
        while(l1.next != null || l2.next != null) {
            toReturn = new ListNode(l1.val + l2.val);

        }
        return toReturn;
    }
    public static class fun {
        public int one = 1;
    }
    public static void main(String[] args) {
        AddTwoNumbers b = new AddTwoNumbers();  // builder for non-statics from static context
        ListNode l1 = b.new ListNode(1, b.new ListNode(2, b.new ListNode(3, b.new ListNode(4, b.new ListNode(5)))));
        ListNode l2 = b.new ListNode(5, b.new ListNode(4,b.new ListNode(3, b.new ListNode(2, b.new ListNode(1)))));
        ListNode sol = b.addTwoNumbers(l1, l2);
        fun l3 = new fun();
    }

}
