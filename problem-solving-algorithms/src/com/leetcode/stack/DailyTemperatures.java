package com.leetcode.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/daily-temperatures/
 * Time and Space: O(n)
 */
public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack();
        // Iterate through the array from the right to left
        for (int i = T.length - 1; i >= 0; --i) {
            /*
                Remove (POP) REPEATEDLY the previous index from the stack if the current number of the index is GREATER
                 than number in the array for index present inside the stack
             */
            while (!stack.isEmpty() && T[i] > T[stack.peek()])
                stack.pop();

            /*
                If the stack is empty, add zero to the ans corresponding to the index or assign the subtraction of the index
                present in the stack with the current index
             */
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;

            // Finally, push the current index to the stack
            stack.push(i);
        }
        return ans;
    }

    /**
     *
     * Faster approach using int array
     */
    public static int[] dailyTemperatures2(int[] T) {
        int[] stack = new int[T.length];
        int top = -1;
        int[] ans = new int[T.length];
        for(int i = 0; i < T.length; i++) {
            while(top > -1 && T[i] > T[stack[top]]) {
                int index = stack[top--];
                ans[index] = i - index;
            }
            stack[++top] = i;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] temps = (dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
        for(int temp : temps) {
            System.out.print(temp + ", ");
        }
    }
}
