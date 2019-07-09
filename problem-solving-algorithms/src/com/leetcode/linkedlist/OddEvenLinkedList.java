package com.leetcode.linkedlist;

public class OddEvenLinkedList {
    public static ListNode oddEvenList(ListNode head) {
        if(head == null)
            return head;

        ListNode odd = head;
        ListNode even = head.next;

        // evenHead will hold the even parts of the list that will be joined to the odd part finally
        ListNode evenHead = even;

        while(even != null && even.next != null) {
            // Make even's next (which is an odd node to odd's next
            odd.next = even.next;

            // Make odd's next node as odd for the next iteration
            odd = odd.next;

            // Make odd's next that got traversed in the above step (line: 16) to even's next number in the list
            even.next = odd.next;

            // Make even's next node as even for the next iteration
            even = even.next;
        }

        // To add the 2nd part (even part) of the list to the odd part
        odd.next = evenHead;
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
        list2.addToFront(5);
        list2.addToFront(4);
        list2.addToFront(3);
        list2.addToFront(2);
        list2.addToFront(1);

        // Printing the original input list
        System.out.print(" Input = ");
        printNode(list2.head);

        ListNode reOrdered = oddEvenList(list2.head);
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
