package javaCode;
/*
 * Adam Ciuris
 * Java 17
 * Solution to leetcode AddTwoNumbers
 * very similar to leetcode solution. Should have just done recursion like scala solution.
 */
public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode toReturn = new ListNode(0);
        ListNode curr, pointer1 = l1, pointer2 = l2;
        int carry = 0, sum = 0;
        curr = toReturn;
        while (pointer1 != null || pointer2 != null) {
            int x = (pointer1 != null) ? pointer1.val : 0; // if boolean evaluates true then left of : otherwise right
            int y = (pointer2 != null) ? pointer2.val : 0;
            sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (pointer1 != null) {
                pointer1 = pointer1.next;
            }
            if (pointer2 != null) {
                pointer2 = pointer2.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return toReturn.next;
    }


    public static void main(String[] args) {
        AddTwoNumbers b = new AddTwoNumbers();  // builder for non-statics from static context
        ListNode l2 = b.new ListNode(9, b.new ListNode(9, b.new ListNode(9, b.new ListNode(9, b.new ListNode(9, b.new ListNode(9, b.new ListNode(9)))))));
        ListNode l1 = b.new ListNode(9, b.new ListNode(9, b.new ListNode(9, b.new ListNode(9))));
        ListNode sol = b.addTwoNumbers(l1, l2);
        System.out.println(sol);
    }

}
