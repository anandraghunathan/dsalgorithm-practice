package com.leetcode.linkedlist;

public class ReverseLinkedList {
    /**
     * Time: O(n)
     * Space: O(1)
     */

    public static ListNode reverseListIteratively(ListNode head) {
        // The reversed list node that will be returned finally
        ListNode prev = null;

        // Input -  1 -> 2 -> null
        // Output - 2 -> 1 -> null

        while(head != null) {
            // Obtain the head.next first
            ListNode next = head.next;  // #1 next = 2 -> 3 -> null | #2 next = 3 -> null |

            // Assign the head's next to prev (that's initially null)
            head.next = prev;           // #1 head = 1 -> null | #2 head = 2 -> 1 -> null

            // Assign the current head of linked list to the prev node
            prev = head;                // #1 prev = 1 -> null | #2 | 2 -> 1 -> null | #3 |

            // Assign the next stored earlier to the head
            head = next;                // #1 head = 2 -> 3 -> null | #2 head = 3 -> null |
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

        /** Recursively reverse the LinkedList */
        ListNode listNode = new ListNode();
        listNode.addToFront(5);
        listNode.addToFront(4);
        listNode.addToFront(3);
        listNode.addToFront(2);
        listNode.addToFront(1);

        // Printing the original input list
        System.out.print("Recursive Input = ");
        ListNode.printNode(listNode.head);

        // Reversing the linked list recursively and printing the output
        ListNode iterativelyreversedList = reverseListIteratively(listNode.head);
        //ListNode recursivelyreversedList = reverseListRecursively(list2.head);
        System.out.print("Recursive Output = ");
        ListNode.printNode(iterativelyreversedList);
        //printNode(recursivelyreversedList);

    }
}
