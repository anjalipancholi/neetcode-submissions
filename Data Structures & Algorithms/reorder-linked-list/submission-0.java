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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int length = 0;
        ListNode node = head;
        // while (node != null) {
        //     node = node.next;
        //     length++;
        // }

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode secondList = reverseList(mid);
        mergeLists(head, secondList);        
    }

    private void mergeLists(ListNode l1, ListNode l2) {
        boolean isOld = true;
        ListNode curr = l1;
        l1 = l1.next;
        while (l1 != null && l2 != null) {
            if (isOld) {
                curr.next = l2;
                l2 = l2.next;
                curr = curr.next;
            } else {
                curr.next = l1;
                l1 = l1.next;
                curr = curr.next;
            }
            isOld = !isOld;
        }
         while (l2 != null) {
            curr.next = l2;
            curr=curr.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            curr.next = l1;
            curr=curr.next;
            l1 = l1.next;
        }
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
