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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode dum = ans;
        int carry=0;
        while((l1!=null && l2!=null))
        {
            int sum=carry+l1.val + l2.val;
            
            if(sum>9)
            {
                int num=sum%10;
                ListNode new1 = new ListNode();
                new1.val=num;
                ans.next=new1;
                ans=ans.next;
                carry=1;
            }   
            else
            {
                ListNode new1 = new ListNode();
                new1.val=sum;
                ans.next=new1;
                ans=ans.next;
                carry=0;
            }
            l1=l1.next;
            l2=l2.next;          
        }
        while(l1!=null)
        {
            int sum=carry+l1.val;
            if(sum>9)
            {
                int num=sum%10;
                ListNode new1 = new ListNode();
                new1.val=num;
                ans.next=new1;
                ans=ans.next;
                carry=1;
            }   
            else
            {
                ListNode new1 = new ListNode();
                new1.val=sum;
                ans.next=new1;
                ans=ans.next;
                carry=0;
            }
            l1=l1.next;
        }
        while(l2!=null)
        {
            int sum=carry+l2.val;
            if(sum>9)
            {
                int num=sum%10;
                ListNode new1 = new ListNode();
                new1.val=num;
                ans.next=new1;
                ans=ans.next;
                carry=1;
            }   
            else
            {
                ListNode new1 = new ListNode();
                new1.val=sum;
                ans.next=new1;
                ans=ans.next;
                carry=0;
            }
            l2=l2.next;
        }        
    
        if(carry!=0)
        {
            ListNode new1 = new ListNode();
                new1.val=carry;
                ans.next=new1;
                ans=ans.next;
        }
        return dum.next;

    }
}
