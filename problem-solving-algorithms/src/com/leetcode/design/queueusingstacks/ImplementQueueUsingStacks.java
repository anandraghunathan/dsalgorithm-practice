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

        Time  : For detailed analysis, https://leetcode.com/problems/implement-queue-using-stacks/solution/
        Space : Refer to the above link
     */
    Stack<Integer> input;
    Stack<Integer> output;
    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
        input = new Stack();
        output = new Stack();
    }

    /** Push element x to the back of queue. */
    // Time : O(1)
    public void push(int x) {
        input.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return output.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(output.empty()) {
            while(!input.empty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input.empty() && output.empty();
    }
}
