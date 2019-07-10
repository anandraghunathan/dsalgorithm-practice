package com.leetcode.linkedlist;

public class ReverseLinkedListII {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null)
            return null;
        ListNode dummy = new ListNode(0);

        // create a dummy node to mark the head of this list
        dummy.next = head;

        // Marker for the node before starting the reversal
        ListNode pre = dummy;

        // Find the start node from where the reversal should happen
        for(int i = 1; i < m; i++) {
            pre = pre.next;
        }

        // Start pointer to the beginning of a sub-list that will be reversed
        ListNode start = pre.next;

        // Then pointer to a node that will be reversed
        ListNode then = start.next;

        // Reverse the nodes from n - m parts of the linked list
        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
        for(int i = 1; i <= n - m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        return dummy.next;
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

    public static void main(String[] args) {
        ListNodeLinkedList list2 = new ListNodeLinkedList();
        list2.addToFront(5);
        list2.addToFront(4);
        list2.addToFront(3);
        list2.addToFront(2);
        list2.addToFront(1);

        // Printing the original input list
        System.out.print("Input  = ");
        printNode(list2.head);

        ListNode reverseBetweenList = reverseBetween(list2.head, 2, 4);
        System.out.print("Output = ");
        printNode(reverseBetweenList);
    }
}
