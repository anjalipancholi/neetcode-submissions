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
    public ListNode removeNthFromEnd(ListNode head, int n) {
         ListNode node = head;
        ListNode lastNode = reverseList(node);
        ListNode lastNodeHead = lastNode;
        if (n==1 && lastNode.next == null) {
            head = null;
            return head;
        }
        ListNode ans = null;
        if (n==1) {
            ans = reverseList(lastNodeHead.next);
            return ans;
        }
        int size = 1;
        while (lastNode != null && lastNode.next != null) {
            if (size == n-1) {
                lastNode.next = lastNode.next.next;
                ans = reverseList(lastNodeHead);
                break;
            }
            lastNode = lastNode.next;
            size++;
        }
        return ans;
    }

    private ListNode reverseList(ListNode node) {
        ListNode curr = node;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
