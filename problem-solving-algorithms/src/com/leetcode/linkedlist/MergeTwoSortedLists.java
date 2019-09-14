package com.leetcode.linkedlist;

/**
 *
 *  https://www.youtube.com/watch?v=GfRQvf7MB3k
 *
 *  Recursive and Iterative solutions
 */
public class MergeTwoSortedLists {
    /**
     *  Time  : O(M + N), at worst we traverse M and N lengths of the two lists
     *  Space : O(1), just shifting pointers
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        // Check if l1 and l2 are not null
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next; // To move the curr's pointer to next to handle the next iteration
        }
        // To handle the final element before which the while loop condition comes out
        curr.next = l1 == null ? l2 : l1;

        // Return the dummy next as it starts from 0
        return dummy.next;
    }

    /*
     *  Time  : O(M + N), M and N are length of the two lists
     *  Space : O(N), recursion stack
     */
    public static ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoListsRecursive(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoListsRecursive(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode res = mergeTwoLists(l1,l2);
        System.out.print(res.val  +" ");
        System.out.print(res.next.val + " ");
        System.out.print(res.next.next.val + " ");
        System.out.print(res.next.next.next.val + " ");
        System.out.print(res.next.next.next.next.val + " ");
        System.out.print(res.next.next.next.next.next.val + " ");
    }
}
