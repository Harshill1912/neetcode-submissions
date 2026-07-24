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
     ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        int len = 0;

    while(temp != null){
        len++;
        temp=temp.next;
    }

    len=len-n;
    temp=dummy;
    int cnt=0;

     while (cnt < len - 1) {
            temp = temp.next;
            cnt++;
        }

        temp.next = temp.next.next;

        return dummy.next;
    }
}
