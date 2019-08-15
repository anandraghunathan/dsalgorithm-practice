package com.leetcode.hard;

import java.util.Stack;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/29018/AC-clean-Java-solution-using-stack
 *
 * Time  : O(N), all the elements in the array are pushed into the stack and popped only once.
 * Space : O(N), worst case when all the elements in the input array are in increasing order like [1, 2, 3, 4, 5]
 */
public class LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length, maxArea = 0;

        Stack<Integer> stack = new Stack<>();

//        for(int i = 0; i < n; i++) {
//            // as long as the current bar is shorter than the last one in the stack
//            // we keep popping out the stack and calculate the area based on
//            // the popped bar
//            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
//                // tricky part is how to handle the index of the left bound
//                /**
//                 *
//                 * Why? --> (i - (stack.isEmpty() ? 0 : (stack.peek() + 1)))
//                 *
//                 * Experiment with input array [1, 3, 2] to get clarified
//                 *
//                 * The width = index of right boundary -> (i) - (index of left boundary + 1) -> (stack.peek() + 1)
//                 * So, width = (i - (stack.peek() + 1))
//                 * Can be further expanded to (i - 1) - (stack.peek() + 1) + 1 = i - 1 - stack.peek().
//                 */
//                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - (stack.isEmpty() ? 0 : (stack.peek() + 1))));
//            }
//            // put current bar'stack index to the stack
//            stack.push(i);
//        }

        for(int i = 0; i < n; i++) {
            // If the stack is empty or current bar is greater than the bar val in the stack, push the current bar into the stack
            if(stack.isEmpty() || heights[stack.peek()] <= heights[i])
                // put current bar'stack index to the stack
                stack.push(i);

            else {
                /*
                    As long as the current bar is shorter than the last one in the stack,
                    we keep popping out the stack and calculate the area based on
                    the popped bar
                */
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    // tricky part is how to handle the index of the left bound
                    /**
                     *
                     * Why? --> (i - (stack.isEmpty() ? 0 : (stack.peek() + 1)))
                     *
                     * Experiment with input array [1, 3, 2] to get clarified
                     *
                     * The width = index of right boundary -> (i) - (index of left boundary + 1) -> (stack.peek() + 1)
                     * So, width = (i - (stack.peek() + 1))
                     * Can be further expanded to (i - 1) - (stack.peek() + 1) + 1 = i - 1 - stack.peek().
                     */
                    int top = stack.pop();
                    int currentArea;
                    if(stack.isEmpty())
                        currentArea = heights[top] * i;
                    else
                        currentArea = heights[top] * (i - (stack.peek() + 1));

                    if(currentArea > maxArea)
                        maxArea = currentArea;
                }
                stack.push(i);
            }
        }

        // finally pop out any bar left in the stack and calculate the area based on it
        while (!stack.isEmpty()) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (n - (stack.isEmpty() ? 0 : (stack.peek() + 1))));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        //System.out.println(largestRectangleArea(new int[]{1,2,3,4,5}));
        System.out.println(largestRectangleArea(new int[]{1,3,2}));
    }
}
