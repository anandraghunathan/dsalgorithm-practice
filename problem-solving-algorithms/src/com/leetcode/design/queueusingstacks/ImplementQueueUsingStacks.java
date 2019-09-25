package com.leetcode.design.queueusingstacks;

import java.util.Stack;

public class ImplementQueueUsingStacks {
    /**
        https://leetcode.com/problems/implement-queue-using-stacks

        https://www.youtube.com/watch?v=Wg8IiY1LbII

        1. We have one input stack, onto which we push the incoming elements, and one output stack,
        from which we peek/pop.
        2. We move elements from input stack to output stack when needed, i.e., when we need to
        peek/pop but the output stack is empty. When that happens, we move all elements from input
        to output stack, thereby reversing the order so it's the correct order for peek/pop.
        3. The loop inside the peek() does the moving from input to output stack. Each element only
        ever gets moved like that ONLY ONCE, and only after we already spent time pushing
        it, so the overall amortized cost for each operation is O(1).

        Time & Space : For detailed analysis, https://leetcode.com/problems/implement-queue-using-stacks/solution/

     */
    Stack<Integer> input;
    Stack<Integer> output;
    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
        input = new Stack();
        output = new Stack();
    }

    /** Push element x to the back of queue. */
    /**
        Time  : O(1)
        Space : O(N), cause we are utilizing a stack to store the element
     */
    public void push(int x) {
        input.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    /**
     *
     *  Time complexity : O(1), worst case O(n)
     *  If the output stack is not empty, we just return the element at the top of the stack. Therefore complexity is O(1), worst case O(n) when output stack is empty
     *
     * Space complexity : O(1)O(1).
     *
     */
    public int pop() {
        peek();
        return output.pop();
    }

    /** Get the front element. */
    /**
     *  Time  : Amortized O(1), Worst-case O(n)
     *
     *         In the worst case scenario when output stack is empty, the algorithm pops n elements from input stack and
     *         pushes n elements to output stack, where n is the queue size. This gives 2n operations, which is O(n).
     *         But when output stack is not empty the algorithm has O(1) time complexity.
     *
     *         Amortized analysis gives the average performance (over time) of each operation in the worst case.
     *         The basic idea is that a worst case operation can alter the state in such a way that the worst case
     *         cannot occur again for a long time, thus amortizing its cost.
     *
     *  Space : O(1)
     */
    public int peek() {
        if(output.empty()) {
            while(!input.empty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    /** Returns whether the queue is empty. */
    /**
     *  Time  : O(1)
     *
     *  Space : O(1)
     *
     */
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}
