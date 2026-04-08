/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) return null;

    // 1. Initialize Min-Heap based on node values
    PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

    // 2. Add the first node of each list into the heap
    for (ListNode node : lists) {
        if (node != null) pq.add(node);
    }

    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;

    // 3. Extract min and add its next node back to the heap
    while (!pq.isEmpty()) {
        ListNode smallest = pq.poll();
        curr.next = smallest;
        curr = curr.next;

        if (smallest.next != null) {
            pq.add(smallest.next);
        }
    }
    return dummy.next;
}   // Initialize a Min-Heap to store all integers
   
}