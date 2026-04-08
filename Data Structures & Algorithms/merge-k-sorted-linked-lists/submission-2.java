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
        // Initialize a Min-Heap to store all integers
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Traverse through each list and add every value to the heap
        for (ListNode list : lists) {
            while (list != null) {
                minHeap.add(list.val);
                list = list.next;
            }
        }
        
        // Use a dummy node to start building the merged list
        ListNode dummy = new ListNode(0);
        ListNode merge = dummy;
        
        // Extract values from the heap in ascending order and create new nodes
        while (!minHeap.isEmpty()) {
            merge.next = new ListNode(minHeap.remove());
            merge = merge.next;
        }
        
        return dummy.next;
    }
}