package com.leetcode.linkedlist;

import java.util.LinkedList;

/** https://leetcode.com/problems/intersection-of-two-linked-lists/ */

public class IntersectionOfLinkedLists {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;

        // Two nodes created from the corresponding head nodes.
        // Used to iterate through list to find the intersection.
        ListNode currA = headA;
        ListNode currB = headB;

        // Check to see if the two current nodes are equal. If not iterate,
        // Scan both the lists, if the list reaches its end, continue to scan
        // the other list. Example: If "currA" reaches the end, assign the "headB"
        // and start scanning iteration again. Now during the second iteration,
        // the two positions will become equal, return that return position
        // that will the end result
        while(currA != currB) {
            currA = currA == null ? headB : currA.next;
            currB = currB == null ? headA : currB.next;
        }
        return currA;
    }

    public static void main(String[] args) {
//        LinkedList list = new LinkedList<>();
//
//        ListNode node1 = new ListNode(4);
//        node1.next = new ListNode(1);
//        node1.next.next = new ListNode(8);
//        node1.next.next.next = new ListNode( 4);
//        node1.next.next.next.next = new ListNode( 5);
//
//        ListNode node2 = new ListNode(5);
//        node2.next = new ListNode( 0);
//        node2.next.next = new ListNode( 1);
//        node2.next.next.next = new ListNode( 8);
//        node2.next.next.next.next = new ListNode(4);
//        node2.next.next.next.next.next = new ListNode( 5);
//
//        System.out.println(getIntersectionNode(node1, node2));
    }
}
