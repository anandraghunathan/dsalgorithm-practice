package com.leetcode.linkedlist;

public class ReverseLinkedList {

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

    public static ListNode reverseListIteratively(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static ListNode reverseListRecursively(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode next = reverseListRecursively(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }

    public static void main(String[] args) {

//        /** Iteratively reverse the LinkedList */
//        ListNodeLinkedList list = new ListNodeLinkedList();
//        list.addToFront(5);
//        list.addToFront(4);
//        list.addToFront(3);
//        list.addToFront(2);
//        list.addToFront(1);
//
//        // Printing the original input list
//        System.out.print("Iterative Input = ");
//        printNode(list.head);
//
//        // Reversing the linked list iteratively and printing the output
//        ListNode iterativelyreversedList = reverseListIteratively(list.head);
//        System.out.print("Iterative Output = ");
//        printNode(iterativelyreversedList);



        /** Recursively reverse the LinkedList */
        ListNodeLinkedList list2 = new ListNodeLinkedList();
        list2.addToFront(5);
        list2.addToFront(4);
        list2.addToFront(3);
        list2.addToFront(2);
        list2.addToFront(1);

        // Printing the original input list
        System.out.print("Recursive Input = ");
        printNode(list2.head);

        // Reversing the linked list recursively and printing the output
        ListNode recursivelyreversedList = reverseListRecursively(list2.head);
        System.out.print("Recursive Output = ");
        printNode(recursivelyreversedList);

    }
}
