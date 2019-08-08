package com.leetcode.linkedlist;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/discuss/11046/My-simple-JAVA-solution-for-share/186959
 */
public class SwapNodesInPairsLinkedList {
    public static ListNode swapPairs(ListNode head) {
        // Final dummy to be returned after swapped
        ListNode dummy = new ListNode(0); //dummy will start from 0 -> 1 -> 2 -> 3 -> 4 -> null
        dummy.next = head;

        // Point Node that we will switch pointers to process each dummy
        ListNode point = dummy;

        // Iteration should end when either the slow or fast pointer becomes null
        while(point.next != null && point.next.next != null) {
            // Two pointers, one faster, other slower
            ListNode swap1 = point.next; // 1 -> 2 -> 3 -> 4 -> null
            ListNode swap2 = point.next.next; // 2 -> 3 -> 4 -> null

            /* First we will point the swap2 (2 -> 3 -> 4 -> null)
                to point.next that will become (0 -> 2 -> 3 -> 4 -> null) */
            point.next = swap1.next;

            /* 1 -> 2 -> 3 -> 4 -> null becomes 1 -> 3 -> 4 -> null */
            swap1.next = swap2.next;

            // 2, 3, 4, null becomes 2 -> 1 -> 3 -> 4 -> null
            swap2.next = swap1;

            /* Assign the modified swap1 (1 -> 3 -> 4 -> null) to the pointer
            for the next iteration */
            point = swap1;
        }
        return dummy.next;
    }

    // The ListNode class implementation
    public static class ListNode {
        private int value;
        private ListNode next;

        public ListNode() {
        }

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
        //list2.addToFront(5);
        list2.addToFront(4);
        list2.addToFront(3);
        list2.addToFront(2);
        list2.addToFront(1);

        // Printing the original input list
        System.out.print(" Input = ");
        printNode(list2.head);

        ListNode reOrdered = swapPairs(list2.head);
        System.out.print(" Output = ");
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
