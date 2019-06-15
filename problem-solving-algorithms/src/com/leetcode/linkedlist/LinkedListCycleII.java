package com.leetcode.linkedlist;

// https://leetcode.com/problems/linked-list-cycle-ii/
public class LinkedListCycleII {
    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) {
                ListNode slow2 = head;
                while(slow2 != slow) {
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
