package com.leetcode.linkedlist;

import java.util.*;

/*
    TODO Review another divide and conquer (Merge sort) approach that's faster (don't have to use PQ too)
        https://leetcode.com/problems/merge-k-sorted-lists/discuss/10640/Simple-Java-Merge-Sort
*/

/**
 * Binary heap (with k items) or a balanced tree structure, there will be a total of "1 + floor(log(k)) levels"
 * that the heap can hold inside. In this, we will have k max items in the binary heap
 *
 * Time : O(n * log(k)), k - Total sorted lists given, n - Total elements across all the lists.
 *        For all the elements across all the lists that is n, we are going to insert into the heap, this will take
 *        log(k) time. In other words, for each element in the list, we do log(k) work.
 *
 *        Similarly, for removal of elements from the heap will take log(k) time.
 *
 *        Therefore - O(2 (n * log(k)), drop the constants, O(n * log(k))
 *
 * Space : O(K), at max the heap is going to hold k items from the given list.
 *
 *
 */
public class MergeKSortedLists {
    /**
     *
     *   1->4->5,
     *   1->3->4,
     *   2->6
     *
     */

    /**
     *  To solve this problem, a PriorityQueue (an abstract datatype (ADT) is implemented as a min heap that will compare
     *  the values every time an offer or poll is called on the heap. The internal implementation of PriorityQueue is
     *  that it takes care of ordering items inside it, so that based on this min heap implementation, it ensures that
     *  the least value is returned during the poll() call.
     *
     *  Also, when an offer is called, it ensure ordering to be added item is compared with the existing top item in the
     *  PQ, the comparator is called to compare the current top item val and the new to-be-added val, and insertion happens
     *  such that the least value gets the top index location in the PQ.
     *
     */
    public static ListNode mergeKLists(List<ListNode> lists) {

        Queue<ListNode> heap = new PriorityQueue(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });

        // A new head node is created to add the merged sorted list.
        // A tail node is also added that's used as a way to manipulate the pointer of the head node.
        ListNode head = new ListNode(0), tail = head;

        // First the lists are added to the PQ (min heap), based on the least starting val
        for (ListNode node : lists) {
            if (node != null)
                heap.offer(node);
        }

        /*
            Then we check if the heap is not empty to go ahead and poll the items in the PQ and add the items in an
            increasing order. We move the tail's pointer to point to its next val keep moving forward.

            If the tail's has a next node, it means that node has to go back into the min heap to perform a comparison
            again. Based on the next's val, it gets added to the top or bottom of the min heap (comparator's compare method
            is called during "heap.offer(tail.next)")

         */
        while (!heap.isEmpty()) {
            tail.next = heap.poll();
            tail = tail.next;
            if (tail.next != null)
                heap.offer(tail.next);
        }
        return head.next;
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
        List<ListNode> listNodes = new ArrayList<>();

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        listNodes.add(list1);
        listNodes.add(list2);
        listNodes.add(list3);

        // Printing the original input list
        System.out.print("<----------------------Input-------------------------->");
        System.out.println();
        System.out.println();
        System.out.print("          List 1 : ");
        printNode(list1);

        System.out.print("          List 2 : ");
        printNode(list2);

        System.out.print("          List 3 : ");
        printNode(list3);
        System.out.print("<----------------------Input-------------------------->");

        ListNode mergeKLists = mergeKLists(listNodes);
        System.out.println();
        System.out.print("Output : ");
        printNode(mergeKLists);
        //System.out.print("--------------------------------");
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
