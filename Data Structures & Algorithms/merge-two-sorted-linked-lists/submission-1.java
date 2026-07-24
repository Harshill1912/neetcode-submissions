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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy=new ListNode(0);
        ListNode temp=dummy;
        ListNode curr1=list1;
        ListNode curr2=list2;

         while(curr1 != null && curr2 !=null ){
            if(curr1.val <= curr2.val){
                ListNode newNode=new ListNode(curr1.val);
                temp.next=newNode;
                curr1=curr1.next;
            }else{
                 ListNode newNode=new ListNode(curr2.val);
                temp.next=newNode;
                curr2=curr2.next;
            }
            temp=temp.next;
         }

         if(curr1 != null) temp.next=curr1;
         if(curr2 != null) temp.next=curr2;

         return dummy.next;
    }
}