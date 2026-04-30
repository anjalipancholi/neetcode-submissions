/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int rem = 0;
        ListNode ans = new ListNode(0);
        ListNode result = ans;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + rem;
            rem = sum/10;
            ans.next = new ListNode(sum%10);
            ans = ans.next;
            l1 = l1.next;
            l2 = l2.next;
        }
         while(l1 != null) {
            int sum = l1.val + rem;
            rem = sum/10;
            ans.next = new ListNode(sum%10);
            ans = ans.next;
            l1 = l1.next;
        }

        while(l2 != null) {
            int sum = l2.val + rem;
            rem = sum/10;
            ans.next = new ListNode(sum%10);
            ans = ans.next;
            l2 = l2.next;
        }
        if (rem != 0) {
            ans.next = new ListNode(rem);
        }
        return result.next;
    }
}
