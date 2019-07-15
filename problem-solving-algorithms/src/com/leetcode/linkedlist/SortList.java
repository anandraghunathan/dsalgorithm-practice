package com.leetcode.linkedlist;

/**
 *
 * https://leetcode.com/problems/sort-list
 *
 *  Time  : n(logn)
 *  Space : O(1) if recursive call stack space isn't considered. Otherwise, O(logn) for the internal recursive stack space used
 *
 */
public class SortList {
    /**
        3 Steps -
            1. Split the list into parts
            2. Sort different parts of the list (call the sort function recursively)
            3. Merge the different parts into the final list
    */
    public static ListNode sortList(ListNode head) {

        /** Step 1 - Split the list into parts. Each part is broken in a way that the list is broken
         * till only one element remains. Calling the sortList fn recursively ensures that.
         * Call stack - First,  l1 = 5 -> null, l2 = 4 -> null,
         * Call stack - Second, l1 = 2 -> null, l2 = 1 -> null,
         * Call stack - Third,  l1 = 3 -> null, l2 = 1 -> 2 -> null
         * Call stack - Fourth, l1 = 4 -> 5 -> null, l2 = 1 -> 2 -> 3 -> null
         *
         * Finally the sorted linked list will be returned back as the result
         *
         */

        if (head == null || head.next == null)
            return head;

        // Solved using 3 pointers
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Setting prev's next to null to split the list
        prev.next = null;

        /** Step 2 - Sort different parts of the list */
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        /** Step 3 - Merge different parts of the list to one final list */
        return merge(l1, l2);
    }

    /**
     For 5, 4, 3, 2, 1, after the first two steps (splitting and sorting),
     l1 = 5, l2 = 4, is given to the merge function. This function below then compares
     the two values, re-arranges it and returns the merged list that will have the sorted
     order of numbers
     */
    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode mergedList = new ListNode(0);
        ListNode pointerList = mergedList;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {

                // Assign the pointer listnode with the l1 node
                pointerList.next = l1;

                // Move the pointer to the next node of the l1 listnode for the next iteration
                l1 = l1.next;

            } else {

                // Assign the pointer listnode with the l1 node
                pointerList.next = l2;

                // Move the pointer to the next node of the l2 listnode for the next iteration
                l2 = l2.next;
            }
            // Move to the pointer to the next node pointer node for the next iteration
            pointerList = pointerList.next;
        }

        /**
            If EITHER the l1 OR l2 is null, the logic drops out of the while loop, therefore we
            have to handle that. For example, for the same l1 = 5, l2 = 4, since l1 > l2, it goes
            to the else condition inside the while loop, after it is done, l2 becomes null.
            Now the while condition is failed, it drops out of the loop. However, we have to
            add 5 to the pointerList node's next to return back the sorted 4 -> 5 -> null list back
        */
        if(l1 != null)
            pointerList.next = l1;

        if(l2 != null)
            pointerList.next = l2;

        // Finally the merged listnode is returned back to the calling function with the sorted list
        return mergedList.next;
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
        list2.addToFront(1);
        list2.addToFront(2);
        list2.addToFront(3);
        list2.addToFront(4);
        list2.addToFront(5);

        // Printing the original input list
        System.out.print(" Input = ");
        printNode(list2.head);

        ListNode reOrdered = sortList(list2.head);
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
