package com.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Intuition:
 *      The approach is same as Next Greater Element I. The only difference here is that we use stack to keep the
 *      indexes of the decreasing subsequence.
 *      Loop once, we can get the Next Greater Number of a normal array - (Next Greater Element I problem).
 *      Loop twice, we can get the Next Greater Number of a circular array - This problem
 *      We loop twice using n * 2, and i % n to deal with the circular array.
 *
 *  Time  : O(N), we loop twice, but the time complexity is still linear.
 *  Space : O(N), res array to store the result will be of size N of the input array.
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length, res[] = new int[n];
        Arrays.fill(res, -1);

        Stack<Integer> stack = new Stack<>(); // index stack
        // Loop twice i < n * 2 to account for the circular array
        for (int i = 0; i < n * 2; i++) {

            // [i % n] to handle even the looping for first and second loop for circular array. Indexes - 11, 12 13..
            int num = nums[i % n];

            // Check if stack is empty and the number at the index at the top of stack is less than current number
            while (!stack.isEmpty() && nums[stack.peek()] < num)
                // Pop the index from stack & add the current num at that index in the res array
                res[stack.pop()] = num;
            /*
                Don't push the index into the stack for the second loop to handle the circular array (after 1st loop
                completes till n - 11, 12, 13...), Only push the index into the stack when its the first loop (i < n)

                In the second loop, no more pushes, we only pop indices already inside the stack
            */
            if (i < n)
                stack.push(i);
        }
        return res; // return the new res array we formed
    }

    public static void main(String[] args) {
        NextGreaterElementII obj = new NextGreaterElementII();
        //int[] res = obj.nextGreaterElements(new int[]{1,2,1});
        //int[] res = obj.nextGreaterElements(new int[]{5,4,3,2,1});
        int[] res = obj.nextGreaterElements(new int[]{100,1,11,1,120,111,123,1,-1,-100});
        int resCount = res.length;

        // Printing output
        System.out.print("[");
        for(int num : res) {
            System.out.print(num);
            System.out.print(resCount-- > 1 ? " ," : "");
        }
        System.out.print("]");
    }
}
