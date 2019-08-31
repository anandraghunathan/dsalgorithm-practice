package com.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 *
 * Can be solved by 2 approaches. Both approach will have linear time.
 * 1. First approach using a HashMap, therefore we use linear space. This is an intuitive solution by keeping a
 *    hash table for each node in the list, via which we just need to iterate the list in 2 rounds respectively to
 *    create nodes and assign the values for their random pointers. As a result, the space complexity of this
 *    solution is O(N), although with a linear time complexity.
 *
 *    Time  : O(N)
 *    Space : O(N)
 *
 * 2. Second approach just uses pointers, therefore constant space. The idea is to associate the original node with its
 *    copy node in a single linked list. In this way, we don't need extra space to keep track of the new nodes.
 *
 *    The algorithm is composed of the following three steps which are also 3 iteration rounds.
 *
 *      1. Iterate the original list, create a copy of each node. The duplicate of each node follows its original immediately.
 *      2. Iterate the new list, assign the random pointer for each duplicated node.
 *      3. Restore the original list and extract the duplicated nodes.
 *
 *    Time  : O(N)
 *    Space : O(1)
 *
 */
public class CopyListWithRandomPointer {

    // 1. Create a clone of the current chain of nodes starting from the head
    // 2. Use a HashMap to store the current node and it's corresponding val into the map
    // 3. Then store the current node's next and random nodes by getting the current node from the map

    /** This can't be tested here in IntelliJ. Main method implementation done only for the second approach */
    public Node copyRandomListLinearSpace(Node head) {
        if(head == null)
            return null;

        Map<Node, Node> map = new HashMap();

        // 1. Create a clone of the chain of nodes
        Node node = head;

        // 2. Store the current node and it's val into the HashMap
        while(node != null) {
            map.put(node, new Node(node.val));

            // Move on to the next node to store it and it's next into the map
            node = node.next;
        }

        // We reassign the head to the node cause it has to re-start from the head after the previous processing
        // to put the node and its value into the hashmap. At the end of the first step, node will be null, so pointing
        // back to the head
        node = head;

        // 3. Store the current node's next and random nodes by getting the current node from the map
        while(node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }

    /**
     *  Modified Question: 1 - > 2 - > null
     *             1. 1's next and random node is pointing to 2.
     *             2. 2's next node and random node is both null.
     *
     *  2. Second approach just uses pointers, therefore constant space. The idea is to associate the original node with its
     *     copy node in a single linked list. In this way, we don't need extra space to keep track of the new nodes.
     *
     *     The algorithm is composed of the following three steps which are also 3 iteration rounds.
     *       1. Iterate the original list, create a copy of each node. The duplicate of each node follows its original immediately.
     *       2. Iterate the new list, assign the random pointer for each duplicated node.
     *       3. Restore the original list and extract the duplicated nodes.
     *
     */
    public Node copyRandomListConstantSpace(Node head) {

        Node curr = head;
        Node next;

        /*
            First step: make copy of each node and link them together side-by-side in a single list.

            Form 1 -> 1 -> 2 -> 2 -> null with 2nd 1 pointing to 2nd 2 as the random node mapping

            Basicallu, clone each node and link each original node to it's copy via the original node's next pointer
         */

        while(curr != null) {

            // Stash the next value of the current node so we do not lose it
            next = curr.next;

            /*
                Create the copy node.
                Point curr (original node)'s next value to the copy.
                Point the next value of the copy node to curr (original node)'s next value.
            */
            Node copy = new Node(curr.val);
            curr.next = copy; // So, 1 - 2 - null becomes 1 -> 1 -> null
            copy.next = next; // So, 1 - 1 - null becomes 1 -> 1 -> 2 -> null


            // Advance to next node in the original list
            curr = next; // return 2 -> null to process the next iteration
        }

        // Second step: assign random pointers for the copy nodes.

        curr = head; // Reset curr to the head of the original list.

        while(curr != null) {

            // Check if the random node is actually present in the original node
            if(curr.random != null) {

                /*
                    Assign clone the random mapping "curr.next.random = curr.random.next" means...
                    Jump to the copy node with "curr.next" and set its random value to.. "curr.random.next" which is
                    the clone node of curr.random KEY IDEA. We use each original node's next value to map to the clone
                    allowing us to reach the clone list. The hashtable did this for us before. This is how we save space
                 */

                // Mapping 1 -> 1'th random node, then 2 -> 2'th random node.
                // curr.random.next because, we created a copy, so we have to pick the second random node
                // And that second random node is curr.random.next
                curr.next.random = curr.random.next;
            }
            /*
                Advance to the next node. But why curr.next.next? Each clone.. points to what? It points
                to the NEXT node of its original node so that we still have reference to that.

                Since we are done with 1 -> 1 in 1 - 1 - 2 - 2 - null, we have do this for
                2 -> 2 next, so curr.next.next
            */
            curr = curr.next.next;
        }

        /*
            Third step: restore the original list, and extract the copy list.

            Our goal is to restore the original list, and extract the copy list. First reset curr to the head of the
            original list.
         */
        curr = head;

        Node copy;
        Node dummyHead = new Node(0); // Dummy head starts with 0
        Node copyCurr = dummyHead;

        // 1 - 1 - 2 - 2 - null
        while(curr != null) {
            /*
                Stash the next value of the curr original node, we access that by saying "curr.next.next"
                We reach to the clone node and hop to that clone node's next node.
            */
            next = curr.next.next; // 1st iteration = 2 -> 2 -> null, 2nd iteration = null

            /*
                Extract the copy node the below three steps

                First iteration,
                1. copy = curr.next;
                        Take the second node from 1 -> 1, assign it to copy node
                        this makes the copy node, 1 -> 2 -> 2 -> null, with
                        random of 1 pointing to 2nd 2
                2. copyCurr.next = copy;
                        Creates a copy of the curr node iteration, therefore
                        this makes the copyCurr node, 0 -> 1 -> 2 -> 2 -> null, with
                        random of 1 pointing to 2nd 2. copyCurr is a pointer to dummyHead
                        that we will return as the result. So the dummyHead will be
                        pointing to 0 -> 1 -> 2 -> 2 -> null, with 1's random pointing
                        to 2nd 2
                3. copyCurr.next = copy;
                        Creates a copy of the curr node iteration, therefore
                        this makes the copyCurr node, 1 -> 2 -> 2 -> null, with
                        random of 1 pointing to 2nd 2.

                        This operation on copyCurr wouldn't affect the dummyHead
                        that we will return as the result. So the dummyHead will be
                        pointing to 0 -> 1 -> 2 -> 2 -> null, with 1's random pointing
                        to 2nd 2. And copyCurr = 1 -> 2 -> 2 -> null

                Second iteration,
                1. copy = curr.next; = 2 -> null, with no random node to process
                2. copyCurr.next; = copy; = 1 -> 2 -> null, with random of 1 pointing to 2.
                   copyCurr is a pointer to dummyHead that we will return as the result.
                   So the dummyHead will be pointing to 0 -> 1 -> 2 -> null
                3. copyCurr = copy; = 2 -> null, with no random node to process, with dummyHead
                   pointing to 0 -> 1 -> 2 -> null
            */
            copy = curr.next;
            copyCurr.next = copy;
            copyCurr = copy;

            /*
                Restore the original list,

                First iteration:
                    Makes the curr, hence the head (curr is a pointer to head) to 1 -> 2 -> 2 -> null,
                    with 1's random as 2 -> 2 -> null

                2nd iteration:
                    Makes the curr, hence the head (curr is a pointer to head) to 1 -> 2 -> null,
                    with 1's random as 2 -> null
            */
            curr.next = next;

            // Assign the new curr node to the next node we picked at the start
            curr = next; // First iteration: curr = 2 -> 2 -> null, 2nd iteration: null
        }

        /*
            The next node to the dummy head is the head of the deeply cloned list we just made. Return to our caller.

            In other words, return the dummyHead.next as dummyHead will start with 0
         */
        return dummyHead.next;
    }

    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getRandom() { return random; }

        public void setRandom(Node random) { this.random = random; }
    }

    // Class that adds elements to the LinkedList implementation and print out the
    static class ListNodeLinkedList {
        private Node head;

        public void addToFront(int value) {
            Node node = new Node(value);
            node.setNext(head);
            node.setRandom(node.next);
            head = node;
        }

        public void addRandom(Node node) {
            while(node != null) {
                if (node.getRandom() == null) {
                    node.setRandom(node.next);
                }
                node.setRandom(head);
            }
            head = node;
        }
    }

    public static void printNode(Node head) {
        Node current = head;

        while(current != null) {
            System.out.print(current.val);
            if(current != null && current.getRandom() != null) {
                System.out.print(" -> Random -> ");
                System.out.print(current.random.val);
            }
            System.out.print(" -> ");
            current = current.getNext();

        }
        System.out.print("null ");
        System.out.print("\n");
        System.out.print("\n");
    }

    public static void printNodeWithRandom(Node head) {
        Node current = head;

        while(current != null) {
            System.out.print(current.val);
            System.out.print(" -> ");
            current = current.getNext();
            current = current.getRandom();
        }
        System.out.print("null ");
        System.out.print("\n");
        System.out.print("\n");
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer obj = new CopyListWithRandomPointer();
        ListNodeLinkedList list = new ListNodeLinkedList();
        list.addToFront(2);
        list.addToFront(1);

        // Printing the original input list
        System.out.print("  Input = ");
        printNode(list.head);
        Node pseudoHead = obj.copyRandomListConstantSpace(list.head);
        System.out.print(" Output = ");
        printNode(pseudoHead);
    }
}
