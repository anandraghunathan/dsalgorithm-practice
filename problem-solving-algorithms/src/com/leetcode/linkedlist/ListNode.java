package com.leetcode.linkedlist;


/**
 * Definition for singly-linked list.
 * public class ListNode
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int x) { val = x; }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    // Class that adds elements to the LinkedList implementation and print out the
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

    ListNode head;
    public void addToFront(int value) {
        ListNode listNode = new ListNode(value);
        listNode.setNext(head);
        head = listNode;
    }
}
