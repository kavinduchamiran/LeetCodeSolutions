package Easy.LinkedListCycle;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {

    // slow, brute force solution
    /*
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }


        HashSet<ListNode> set = new HashSet<>();
        set.add(head);

        while (!set.contains(head.next)) {
            set.add(head.next);

            if (head.next == null) {
                return false;
            }

            head = head.next;

        }

        return true;
    }
    */

    // optimized solution using Floyd's Tortoise and Hare algorithm
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        // we are going to have 2 pointers, starting at the head of the list
        ListNode slow = head;
        ListNode fast = head;

        // we are going to advance slow by 1 node, fast by 2 nodes
        // since the fast pointer is going to reach the end (assuming no cycle), we loop until that happens
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }
}
