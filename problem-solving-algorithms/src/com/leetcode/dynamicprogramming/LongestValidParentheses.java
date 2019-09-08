package com.leetcode.dynamicprogramming;

import java.util.Stack;

public class LongestValidParentheses {
    // Sample Input - ")()())"

    /**
     * Stack approach
     * Runtime: O(n)
     * Space  : O(n)
     */
    public static int longestValidParentheses(String s) {
        if (s.length() == 0)
            return 0;

        int maxLength = 0;

        // Stack that will hold the index of open brackets
        Stack<Integer> stack = new Stack();

        // push a dummy value
        stack.push(-1);

        // Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            // Push into the stack if the present character is a open bracket
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // If the present character is not an open bracket, pop the top element from the stack
                stack.pop();
                // If the stack is empty after popping, push the current character into the stack
                if (stack.empty())
                    stack.push(i);
                else
                    // If the stack isn't empty, then calculate the max length by subtracting the current index
                    // against the stack's top element value.
                    maxLength = Math.max(maxLength, i - stack.peek());
            }
        }
        return maxLength;
    }

    /**
     *
     * Without adding extra space. Same O(n) solution.
     */
    public static int longestValidParentheses2(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        /**
         * When scanning from left to right, you might end up with a positive value for 'left'.
         * Say, your left ends up with 4 and right ends up with 3. This means there could be 3 valid
         * pairs giving an answer of 6. But you never got the chance to calculate that because your "left" has always
         * managed to stay more than "right". Example: "(((()))"
         */
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }

    public static void main(String[] args) {
        /** First approach using stack. Linear runtime and space complexity */
        //System.out.println(longestValidParentheses(")()())"));

        /** Second approach - No extra memory usage */
        //System.out.println(longestValidParentheses2(")()())"));

        /** Unique test case to test the second for loop of the 2nd approach - (((())) */
        System.out.println(longestValidParentheses2("(((()))"));
    }
}
