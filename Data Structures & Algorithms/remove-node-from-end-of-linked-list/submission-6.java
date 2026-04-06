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

        if(head.next==null)
        {
            
            ListNode ans = null;
            return ans;
        }
        else if(head.next.next==null && n==1)
        {
            head.next=null;
            return head;
        }
        else if(head.next.next==null && n==2)
        {
            ListNode ans=head.next;
            return ans;
        }
        ListNode rev = reverse(head);
        ListNode part=rev;
        if (n==1)
        {
            rev=part.next;
            ListNode ans = reverse(rev);
            return ans;
            
        }
        for(int i=0;i<n-2;i++)
        {
            part=part.next;
        }
        part.next=part.next.next;
        ListNode ans = reverse(rev);
        return ans;



    }
    public ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null)
        {
            ListNode next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        return prev;
    }
}
