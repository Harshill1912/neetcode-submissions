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
        Stack<ListNode> st=new Stack<>();
        ListNode temp=head;
        int len=0;

        while(temp != null){
            st.push(temp);
            len++;
            temp=temp.next;
        }

        int cnt=0;
        temp=head;

        while( cnt < len/2){
            ListNode stackNode = st.pop(); 
            ListNode curr = temp.next;   
            
            temp.next = stackNode;  
            stackNode.next = curr;        
            temp = curr;                 
            
            cnt++;
        }

        if(temp != null){
            temp.next=null;
        }
    }
}
