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
    public ListNode mergeKLists(ListNode[] lists) 
    {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (true) {
            int minIndex = -1;
            // 1. Find the smallest head among all K lists
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (minIndex == -1 || lists[i].val < lists[minIndex].val) {
                        minIndex = i;
                    }
                }
            }

            // 2. If no heads are left, we are done
            if (minIndex == -1) break;

            // 3. Add the smallest to our result and move that pointer
            curr.next = lists[minIndex];
            curr = curr.next;
            lists[minIndex] = lists[minIndex].next;
        }
        return dummy.next;
    }
}
