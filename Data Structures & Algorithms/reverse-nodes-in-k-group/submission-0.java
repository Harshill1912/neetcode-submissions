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
    public  ListNode  reverse(ListNode head,int k){
        ListNode prev = null;
        ListNode curr = head;

        while (k-- > 0 && curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
         if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode temp = dummy;

        ListNode curr = head;

        while (true) {
            
            ListNode check = curr;
            int count = 0;
            while (count < k && check != null) {
                check = check.next;
                count++;
            }

            if (count < k) break; 

            ListNode nextGroup = check;

            ListNode revHead = reverse(curr, k);

            temp.next = revHead;

            temp = curr;

            curr.next = nextGroup;
            curr = nextGroup;
        }

        return dummy.next;

    }
}
