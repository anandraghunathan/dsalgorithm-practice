package com.leetcode.tree.bst;

import com.leetcode.tree.TreeNode;

/**
 *
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 *
 * Solution Approach 3
 *
 * In-order Tree Traversal Simulation
 *
 * Time  : O(N), since we still have to process each of the nodes in the linked list once and form corresponding BST nodes.
 * Space : O(log N), since now the only extra space is used by the recursion stack and since we are building a height balanced BST, the height is bounded by logN.
 */
public class ConvertSortedLinkedListToBST {
    private static ListNode listNodeHead;

    // To find the size of the input list given
    private static int findSize(ListNode head) {
        ListNode ptr = head;
        int c = 0;
        while (ptr != null) {
            ptr = ptr.next;
            c++;
        }
        return c;
    }

    /**
     *
     *  Input Linked List : -10 -> -3 -> 0 -> 5 -> 9 -> null
     *
     *  After Tree Conversion : -10, -3, 0, 5, 9,
     *
     */
    private static TreeNode convertListToBST(int lo, int hi) {
        // Invalid case
        if (lo > hi) {
            return null;
        }

        /*
            We have to simulate the inorder traversal here. We can find out the middle element by using
            (lo + hi) / 2. Note that we don't really find out the middle node of the linked list. We just have a variable
             telling us the index of the middle element. We simply need this to make recursive calls on the two halves.
         */
        int mid = (lo + hi) / 2;

        // First step of simulated inorder traversal. Recursively form the left half
        TreeNode left = convertListToBST(lo, mid - 1);

        // Once left half is traversed, process the current node
        TreeNode node = new TreeNode(listNodeHead.val);
        node.left = left;

        /*
            The invariance that we maintain in this algorithm is that whenever we are done building the left half
            of the BST, the head pointer in the linked list will point to the BST's root node or the middle node (which
            becomes the BST's root). So, we simply use the current value pointed to by head as the root node and progress
            the head node by once i.e. head = head.next
         */

        // Maintain the invariance mentioned in the algorithm (above)
        listNodeHead = listNodeHead.next;

        // Recurse on the right hand side and form BST out of them
        node.right = convertListToBST(mid + 1, hi);
        return node;
    }

    public static TreeNode sortedListToBST(ListNode head) {
        // Get the size of the linked list first
        int size = findSize(head);

        listNodeHead = head;

        // Form the BST now that we know the size
        return convertListToBST(0, size - 1);
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

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        // Printing the original input list
        System.out.print("<----------------------Input------------------------------------>");
        System.out.println();
        System.out.println();
        System.out.print("     Input Linked List : ");
        printNode(head);
        //System.out.print("<----------------------Input---------------------------------->");

        TreeNode treeNode = sortedListToBST(head);

        //System.out.println();
        //System.out.println();
        System.out.print("<----------------------Output---------------------------------->");
        System.out.println();
        System.out.println();
        System.out.print("     After Tree Conversion : ");

        System.out.print(treeNode.left != null ? treeNode.left.val + ", " : null + ", ");

        System.out.print(treeNode.left.right != null ? treeNode.left.right.val + ", "  : null + ", ");

        System.out.print(treeNode != null ? treeNode.val + ", " : null + " , ");

        System.out.print(treeNode.right != null ? treeNode.right.val + ", " : null + ", ");

        System.out.print(treeNode.right.right != null ? treeNode.right.right.val + ", "  : null + ", ");
        System.out.println();
        System.out.println();
        System.out.print("<-----------------------End------------------------------------>");
    }
}
