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
    public ListNode mergeKLists(ListNode[] lists) {
    List<Integer> nodes = new ArrayList<>();
    // 1. Traverse everything and add to ArrayList
    for (ListNode list : lists) {
        while (list != null) {
            nodes.add(list.val);
            list = list.next;
        }
    }
    // 2. Use Java's built-in Sort
    Collections.sort(nodes);

    // 3. Build a new Linked List from the sorted values
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    for (int val : nodes) {
        curr.next = new ListNode(val);
        curr = curr.next;
    }
    return dummy.next;
}
}
