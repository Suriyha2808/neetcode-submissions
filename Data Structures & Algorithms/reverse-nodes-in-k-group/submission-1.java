class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode sam = head;
        ListNode prev = null;
        ListNode finalHead = null; // To store the new head of the whole list
        ListNode saved = null;     // To connect the previous group to the current one
        
        while (sam != null) {
            // 1. Check if there are k nodes left
            ListNode check = sam;
            boolean canReverse = true;
            for (int i = 0; i < k; i++) {
                if (check == null) {
                    canReverse = false;
                    break;
                }
                check = check.next;
            }

            if (canReverse) {
                ListNode groupTail = sam; // This will be the end of the group after reversal
                ListNode groupPrev = null;
                ListNode curr = sam;
                
                // 2. Standard Reversal for K nodes
                for (int i = 0; i < k; i++) {
                    ListNode next = curr.next;
                    curr.next = groupPrev;
                    groupPrev = curr;
                    curr = next;
                }

                // 3. Connect this group
                if (finalHead == null) {
                    finalHead = groupPrev; // First group's new head is the total list's head
                } else {
                    saved.next = groupPrev; // Connect previous group's tail to this group's head
                }

                saved = groupTail; // Update 'saved' to the tail of the current reversed group
                sam = curr;        // Move 'sam' to the start of the next group
            } else {
                // 4. Not enough nodes left? Connect the remaining as-is and break
                if (saved != null) {
                    saved.next = sam;
                }
                break;
            }
        }
        return finalHead != null ? finalHead : head;
    }
}