package com.leetcode.linkedlist;

public class PartitionList {
    public static ListNode partition(ListNode head, int x) {

        ListNode smallerHead = new ListNode(0), greaterHead = new ListNode(0);  //dummy heads of the 1st and 2nd queues
        ListNode smallerLast = smallerHead, greaterLast = greaterHead;      //current tails of the two queues;
        while (head != null){
            if (head.val < x) {
                smallerLast.next = head;
                smallerLast = smallerLast.next;
            } else {
                greaterLast.next = head;
                greaterLast = greaterLast.next;
            }
            head = head.next;
        }
        greaterLast.next = null;
        smallerLast.next = greaterHead.next; //Skipping dummy head of greater and linking
        return smallerHead.next; //Skipping dummy head of smaller and returning next
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(2);

        ListNode res = partition(node, 3);
        System.out.print(res.val  +" ");
        System.out.print(res.next.val + " ");
        System.out.print(res.next.next.val + " ");
        System.out.print(res.next.next.next.val + " ");
        System.out.print(res.next.next.next.next.val + " ");
        System.out.print(res.next.next.next.next.next.val + " ");

    }
}
