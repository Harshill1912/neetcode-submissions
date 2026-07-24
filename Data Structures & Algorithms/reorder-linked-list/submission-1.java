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
        ListNode temp=head;
        Stack<ListNode> st=new Stack<>();

        while(temp != null){
            st.push(temp);
            temp=temp.next;
        }

        int len=st.size();
        int cnt=0;
        

        while(cnt < (len/2)){
        ListNode mid=st.pop();
        mid.next=head.next;
        head.next=mid;
        head=head.next.next;
        cnt++;
        }

        head.next=null;

    }
}
