package com.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    Queue<Integer> queue;
    /** Initialize your data structure here. */
    public ImplementStackUsingQueues() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack.
     *
     * Time : O(n). The algorithm removes n elements and inserts n + 1 elements to q1, where n is the stack size.
     *              This gives 2n + 12n+1 operations. The operations add and remove in linked lists has O(1) complexity.
     *
     * Space complexity : O(1).
     */
    public void push(int x) {
        queue.offer(x);
        // Rotate the queue to add the last (tail) element to be the head
        for(int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll()); // Poll the current last element and add it again to the front of the queue
        }
    }

    /**
     *  Removes the element on top of the stack and returns that element.
     *
     *  Time  : O(1)
     *  Space : O(1)
     */
    public int pop() {
        return queue.poll();
    }

    /**
     *  Get the top element.
     *
     *  Time  : O(1)
     *  Space : O(1)
     */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty.
     *
     *  Time  : O(1)
     *  Space : O(1)
     */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues obj = new ImplementStackUsingQueues();
        obj.push(1);
        obj.push(2);
        System.out.println("Top : " +obj.top());
        System.out.println("Pop : " +obj.pop());
        System.out.println("Is Empty? : " +obj.empty());
    }
}
