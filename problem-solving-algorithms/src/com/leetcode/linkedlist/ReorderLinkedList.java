package com.leetcode.linkedlist;

/**
 * https://leetcode.com/problems/reorder-list
 *   3 steps process.
 *      1. Find the middle node of the given linked list
 *      2. Reverse the second half of the given linked list
 *      3. Merge the first and second part together
 */
public class ReorderLinkedList {
    public static ListNode reorderList(ListNode head) {
        if (head == null) {
            return null;
        }

        /** 1st Step - Find the middle node - Sample input 1 -> 2 -> 3 -> 4 -> 5 -> null */
        // Slow node reaches node 3
        // Fast node reaches the end null
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half - Pass 3's next node 4 -> 5 -> null to the generic reverse linkedlist method
        ListNode head2 = reverse(slow.next);

        // Make the slow.next null to avoid chaining a never ending loop of 3 -> 4 -> null, here its modified as 3 -> null
        slow.next = null;

        /** 3rd Final Step - Link the two halves together */
        // First half  head1 = 1 -> 2 -> 3 -> null
        // Second hald head2 = 5 -> 4 -> null

        // The below is not required, but added to make it debug in IntelliJ
        ListNode head1 = head;

        while (head1 != null && head2 != null) {

            // Take temp values
            // head1.next = 2 -> 3 -> null
            // head2.next = 4 -> null
            ListNode tmp1 = head1.next;
            ListNode tmp2 = head2.next;

            // The head2.next 4 has to become 2 -> 3 -> null. Therefore, 5 -> 2 -> 3 -> null
            head2.next = head1.next;

            // The head1.next has to become 1 -> 5 -> 2 -> 3 -> null. Modified from previous changed in the line above
            head1.next = head2;

            // Assign back the temp values stored to the next iteration
            head1 = tmp1;
            head2 = tmp2;
        }
        return head;
    }

    /** 2nd Step - Reverse second half of the linked list using generic reverse linked list concept */
    private static ListNode reverse(ListNode n) {
        ListNode prev = null;
        ListNode cur = n;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }

    // The ListNode class implementation
    public static class ListNode {
        private int value;
        private ListNode next;

        public ListNode(int value) {
            this.value = value;
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
        System.out.print("Recursive Input = ");
        printNode(list2.head);

        ListNode reOrdered = reorderList(list2.head);
        System.out.print("Recursive Output = ");
        printNode(reOrdered);
    }

    public static void printNode(ListNode head) {
        ListNode current = head;

        while(current != null) {
            System.out.print(current.value);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.print("null ");
        System.out.print("\n");
        System.out.print("\n");
    }
}
