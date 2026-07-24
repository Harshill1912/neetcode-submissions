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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy=new ListNode(0);
        ListNode temp1=dummy;
        int cnt=1;
        ListNode temp=head;

        while(temp != null){
            temp=temp.next;
            cnt++;
        }

        for(int i=1;i<left;i++){
            temp1.next=head;
            temp1=temp1.next;
            head=head.next;
        }

        ListNode temp2=null;

        for(int i=left;i<=right;i++){
            ListNode newNode=new ListNode(head.val);
            newNode.next=temp2;
            temp2=newNode;
            head=head.next;
        }

        while(temp2 != null){
            temp1.next=temp2;
            temp1=temp1.next;
            temp2=temp2.next;
        }


        while(head != null){
            temp1.next=head;
            temp1=temp1.next;
            head=head.next;
        }

        return dummy.next;

           
        
    }
}