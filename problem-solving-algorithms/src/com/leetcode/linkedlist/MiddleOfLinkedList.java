package com.leetcode.linkedlist;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        if(head == null)
            return head;

        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
