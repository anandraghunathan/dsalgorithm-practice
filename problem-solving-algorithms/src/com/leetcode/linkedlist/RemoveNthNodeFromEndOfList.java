package com.leetcode.linkedlist;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/solution/
 *
 *
 *      Intuition:
 *             Use 2 pointer approach to maintain a gap of n nodes between
 *             the fast and slow pointer. Maintain the same gap between
 *             the two nodes, finally when the fast pointer is null, the
 *             slow pointer meanwhile will be pointing to the nth node
 *             counting from the end of the list. In other words, the slow
 *             node will be n + 1 places behind the fast node, just at the
 *             right spot for it to be able to skip it's next
 *             pointer to point to it's next to next node.
 *
 */
public class RemoveNthNodeFromEndOfList {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Solve using two pointers
        ListNode fast = dummy;
        ListNode slow = dummy;

         /*
            The fast pointer advances the list by n+1 steps from the beginning,
            while the slow pointer starts from the beginning of the list.
            Now, gap between fast and slow pointers is n nodes apart
         */
        for(int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }

        /*
            We maintain this constant gap by advancing both pointers together at the same speed
            until the fast pointer arrives past the last node (end)
        */
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        /*
            The slow pointer will be pointing at the nth node counting from the last.
            In other words, the slow pointer will n + 1 places behind the fast pointer.
            Just at the right spot for it to be able to skip the next node and relink
            the next pointer of the second node to point to it's next to next node.
        */
        slow.next = slow.next.next;
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

        ListNode reOrdered = removeNthFromEnd(list2.head, 2);
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
