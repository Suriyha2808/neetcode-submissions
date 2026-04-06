public class Solution {
    public boolean hasCycle(ListNode head) {
        // Edge case: Null or single node can't have a cycle
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        // Move fast by two and slow by one
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If they meet, it's a cycle
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}