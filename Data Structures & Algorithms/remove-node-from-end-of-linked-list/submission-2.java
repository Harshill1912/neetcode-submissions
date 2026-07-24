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
           int len = 0;
    ListNode temp = head;

    while (temp != null) {
        temp = temp.next;
        len++;
    }

    int remove = len - n;

    if (remove == 0) {
        return head.next; // Remove head
    }

    temp = head;
    ListNode prev = null;
    int cnt = 0;

    while (cnt < len) {
        if (cnt == remove) {
            prev.next = temp.next;
            temp.next = null;
            break;
        } else {
            prev = temp;
            temp = temp.next;
        }
        cnt++;
    }

    return head;
    }
}
