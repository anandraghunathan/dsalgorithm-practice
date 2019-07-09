package com.leetcode.linkedlist;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/submissions/
 */
public class RemoveDuplicatedSortedLinkedList {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;

        while(curr != null && curr.next != null) {
            if(curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
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
        list2.addToFront(3);
        list2.addToFront(3);
        list2.addToFront(2);
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
