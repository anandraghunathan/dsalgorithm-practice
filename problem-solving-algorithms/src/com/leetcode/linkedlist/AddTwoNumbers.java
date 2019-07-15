package com.leetcode.linkedlist;

/**
 * https://leetcode.com/problems/add-two-numbers
 * Time: O(max(m, n))
 * Space: O(max(m, n))
 *
 */
public class AddTwoNumbers {
    /**
     *
     * Keep track of the carry using a variable and simulate digits-by-digits sum starting from the head of list, which contains the least-significant digit.
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        // Only when p OR q is not null
        while(p != null || q != null) {

            // If the val has reached the end of the list (meaning val is null), set 'x' or 'y' to 0
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;

            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);

            // Advance the curr's node to next
            curr = curr.next; /** Required to not overwrite the old value number with the new one.
             This will add the new number as a new node every time */

            // Advance both p and q to the next node
            if(p != null) p = p.next;
            if(q != null) q = q.next;
        }
        /*
            To handle edge cases when last addition inside the loop yields a carry of 1,
            since p or q is null, drops out of the loop. Example l1 = [5], l2 = [5], carry is 1,
            we should return [0, 1], but if the below check is not performed, only [0] will be returned
        */
        if(carry > 0)
            curr.next = new ListNode(carry);
        return dummy.next;
    }

    // The ListNode class implementation
    public static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    // Class that adds elements to the LinkedList implementation and print out the
    public static class ListNodeLinkedList {
        private ListNode head;

        public void addToFront(int value) {
            ListNode node = new ListNode(value);
            node.setNext(head);
            head = node;
        }
    }

    public static void printNode(ListNode head) {
        ListNode current = head;

        while(current != null) {
            System.out.print(current.val);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.print("null ");
        System.out.print("\n");
        System.out.print("\n");
    }

    public static void main(String[] args) {
        ListNodeLinkedList l1 = new ListNodeLinkedList();
        /** Edge cases to test carry scenario at end of the list */
//        l1.addToFront(3);
//        l1.addToFront(4);
//        l1.addToFront(2);
//
//        ListNodeLinkedList l2 = new ListNodeLinkedList();
//        l2.addToFront(8);
//        l2.addToFront(6);
//        l2.addToFront(5);

        /** Edge cases to test
         *  1. One list is smaller than the other
         *  2. One list is null, the other is not.
         */

        l1.addToFront(1);
        l1.addToFront(0);

        ListNodeLinkedList l2 = new ListNodeLinkedList();
        l2.addToFront(2);
        l2.addToFront(1);
        l2.addToFront(0);

        // Printing the original input list
        System.out.print("L1  = ");
        printNode(l1.head);
        System.out.print("L2  = ");
        printNode(l2.head);

        ListNode reverseBetweenList = addTwoNumbers(l1.head, l2.head);
        System.out.print("Add = ");
        printNode(reverseBetweenList);
    }
}
