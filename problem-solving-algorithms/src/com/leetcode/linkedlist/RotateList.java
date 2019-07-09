package com.leetcode.linkedlist;


/**
 * https://leetcode.com/problems/rotate-list/
 */
public class RotateList {
    /**
     * 1. Solved using two pointers, one fast another slow, fast is used to calculate the length of the list, and then
     * rotation is performed to the linked list
     *
     * 2. The length - l % length logic is used to handle the scenario when give k is larger than the list length
     *
     */

    public static ListNode rotateRight(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head, slow = head;
        int length = 1; // since we are already at head node

        while(fast.next != null) { //Get the total length of the list
            length++;
            fast = fast.next;
        }

        for(int i = length - k % length; i > 1; i--) // length - k % length to handle k < list length and i>1 because we need to put slow.next at the start.
            slow = slow.next;

        // For 1 2 3 4 5 and k = 4
        // 1st step does 1 > 2 > 3 > 4 > 5 > 1 > 2 > 3 > 4 > 5 > 1 ...
        fast.next = dummy.next; //Do the rotation

        // 1 > 2 > 3 > 4 > 5 > 1 > 2 > 3 > 4 > 5 > 1 ...  becomes 2 > 3 > 4 > 5 > 1 > 2 > 3 > 4 > 5 > 1
        dummy.next = slow.next;

        // disconnect the chain to stop looping over and over.
        slow.next = null;

        // Return the rotated list
        return dummy.next;
    }

    // The ListNode class implementation
    public static class ListNode {
        private int val;
        private ListNode next;

        public ListNode() {
        }

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

    public static void main(String[] args) {
        ListNodeLinkedList list2 = new ListNodeLinkedList();
        list2.addToFront(5);
        list2.addToFront(4);
        list2.addToFront(3);
        list2.addToFront(2);
        list2.addToFront(1);

        // Printing the original input list
        System.out.print(" Input = ");
        printNode(list2.head);

        ListNode reOrdered = rotateRight(list2.head, 4);
        System.out.print(" Output = ");
        printNode(reOrdered);
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
}
