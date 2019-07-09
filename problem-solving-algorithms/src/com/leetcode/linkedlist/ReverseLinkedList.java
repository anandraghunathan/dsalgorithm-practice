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

    /**
     * Time: O(n)
     * Space: O(1)
     */

    public static ListNode reverseListIteratively(ListNode head) {
        // The reversed list node that will be returned finally
        ListNode prev = null;

        while(head != null) {
            // Obtain the head.next first
            ListNode next = head.next;

            // Assign the head's next to prev (that's initially null)
            head.next = prev;

            // Assign the current head of linked list to the prev node
            prev = head;

            // Assign the next stored earlier to the head
            head = next;
        }
        return prev;
    }

    public static ListNode reverseListRecursively(ListNode head) {
        /* Since its recursion, first validate whether the head and
            head's next aren't null. If its null, return the current head */
        if(head == null || head.next == null)
            return head;

        /* Call the same method recursively. So, 1 being the current head gets
        called first, then 2, finally, when the head is 5, and since its next == null,
        5 gets returned as the head */
        ListNode next = reverseListRecursively(head.next);

        /* When the recursive call gets returned to caller method call,
            we can reverse the linked list by assigning the head.next.next,
            which is 4.5.null to the head itself. Therefore, the next node will
            become 5 -> 4 -> 5 -> 4 -> 5 -> 4 in a chain*/
        head.next.next = head;

        /* To stop the chaining and to cut it off, assign the head.next to null
            Thus, the next node will now have 5 -> 4 -> null*/
        head.next = null;

        // Return the next node that will be reversed now
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
//        list2.addToFront(3);
//        list2.addToFront(2);
//        list2.addToFront(1);

        // Printing the original input list
        System.out.print("Recursive Input = ");
        printNode(list2.head);

        // Reversing the linked list recursively and printing the output
        ListNode iterativelyreversedList = reverseListIteratively(list2.head);
        //ListNode recursivelyreversedList = reverseListRecursively(list2.head);
        System.out.print("Recursive Output = ");
        printNode(iterativelyreversedList);
        //printNode(recursivelyreversedList);

    }
}
