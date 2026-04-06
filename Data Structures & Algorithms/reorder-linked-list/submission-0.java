class Solution {
    public void reorderList(ListNode head) {
        // 1. Edge case: if list has 0, 1, or 2 nodes, no reordering needed
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode currStart = head;

        // 2. Loop until we don't have enough nodes left to swap
        while (currStart != null && currStart.next != null && currStart.next.next != null) {
            
            // 3. Find the node BEFORE the last node
            ListNode prevToLast = currStart;
            while (prevToLast.next.next != null) {
                prevToLast = prevToLast.next;
            }

            // 4. Perform the "surgery"
            ListNode lastNode = prevToLast.next;
            prevToLast.next = null; // Cut the last node off
            
            ListNode nextNode = currStart.next;
            currStart.next = lastNode;
            lastNode.next = nextNode;

            // 5. Move the "start" pointer two steps forward (past the newly inserted tail)
            currStart = nextNode;
        }
    }
}