package com.leetcode.linkedlist;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class RemoveDuplicatedSortedLinkedListII {
    public static ListNode deleteDuplicates(ListNode head) {
        // Dummy node that will be modified
        ListNode dummy = new ListNode(0);

        // Assigning dummy's next that starts with 0 -> to the head
        dummy.next = head;

        /*
            The prev will carry the previous pointer node that helps to take
            a call to either retain or remove node based on
        */
        ListNode prev = dummy;

        // Points to the curr node that's traversed
        ListNode curr = head;

        while(curr != null) {
            // Null check for curr's next node
            while(curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            /*
                1. IF - the curr node is the same as the prev's next node, then
                    move the prev's node to it's next node.
                2. ELSE - Make the curr's next node as the prev's next node
            */
            if(prev.next == curr)
                prev = prev.next;
            else
                prev.next = curr.next;

            // For the next iteration, process the curr's next node
            curr = curr.next;
        }
        // Return the dummy's next node cause dummy starts from 0.
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
//        list2.addToFront(5);
//        list2.addToFront(4);
//        list2.addToFront(4);
//        list2.addToFront(3);
//        list2.addToFront(3);
//        list2.addToFront(2);
//        list2.addToFront(1);

        list2.addToFront(5);
        list2.addToFront(4);
        list2.addToFront(4);
        list2.addToFront(3);
        list2.addToFront(1);
        list2.addToFront(1);
        list2.addToFront(1);

        // Printing the original input list
        System.out.print(" Input = ");
        printNode(list2.head);

        ListNode reOrdered = deleteDuplicates(list2.head);
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
