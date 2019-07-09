package com.leetcode.linkedlist;

/** https://leetcode.com/problems/palindrome-linked-list/ */
public class PalindromeLinkedList {

    /**
     * Time: O(n)
     * Space: O(1)
     */

    public boolean isPalindrome(ListNode head) {

        // Have two pointer nodes, assign the head to both
        ListNode fast = head, slow = head;

        // Validate if the fast pointer and its next are not null
        while(fast != null && fast.next != null) {

            // Assign fast and slow pointer nodes

            // Fast pointer goes to the end,
            fast = fast.next.next;

            // Slow pointer goes to the middle
            slow = slow.next;
        }

        /*
            1. Call the usual reverse linked list method to reverse the
            second half of the list

            2. Now the slow pointer becomes the head for the second half of
            the linked list
        */
        slow = reverse(slow);

        // Assign the first half or the original head to the fast pointer
        fast = head;

        // Run the slow and fast pointers to compare if the values are the same
        while(slow != null) {

            // If the values are not same, return false
            if(fast.val != slow.val)
                return false;

            /*
                Else move on to the next node, keep repeating for all nodes comparing
                all the fast (left node values) pointer moving from left to right
                against the slow (right node values) pointer moving right to left
             */
            fast = fast.next;
            slow = slow.next;
        }
        // If the linked list is a palindrome, we will return true
        return true;
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    // Reverse linked list implementation
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
