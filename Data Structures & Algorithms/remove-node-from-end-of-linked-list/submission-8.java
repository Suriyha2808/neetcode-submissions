class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 1. Create a dummy node to handle removing the head easily
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;

        // 2. Move 'fast' pointer n + 1 steps ahead
        // (n + 1 ensures 'slow' stops right BEFORE the target node)
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // 3. Move both until 'fast' hits the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // 4. Skip the Nth node
        slow.next = slow.next.next;

        // 5. Return dummy.next (not head, in case head was removed)
        return dummy.next;
    }
}