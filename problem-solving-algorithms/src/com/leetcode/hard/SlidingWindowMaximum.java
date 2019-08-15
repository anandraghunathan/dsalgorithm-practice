package com.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 *
 * Time  : O(n), each element in the array is pushing and polling from and into the deque only once.
 * Space : O(k), where k is the max number of elements the deque can hold at the particular time.
 */
public class SlidingWindowMaximum {
    /**
     *
     * We use Deque because of its unique nature of being a linear collection that supports element insertion and removal at both ends.
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        // Null/Empty input values
        if(n == 0 || k <= 0)
            return new int[]{};

        // We will add the max numbers into this array
        int[] maxWindow = new int[n - k + 1];

        // Index value that will be used to construct the result maxWindow array
        int currentMaxIndex = 0;

        // We will add the indexes from the nums to the queue, and slide to the next position of the array at each iteration
        Deque<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            // Poll the number if the index is out the window of k = 3
            if(!queue.isEmpty() && queue.peek() < i - k + 1)
                queue.poll();

            /*
                Poll the prior number added to the queue if that number is less than the current number.

                We then discard elements smaller than nums[i] from the tail.
                This is because if nums[x] < nums[i] and x < i, then nums[x] has no chance to be the "max" in
                [i-(k-1), i], or any other subsequent window: nums[i] would always be a better candidate.
             */
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i])
                queue.pollLast();

            /*
                Add the current bigger number to the queue

                The elements in the deque are ordered in both sequence in array and their value in the maxWindow array.
                At each step the head of the deque is the max element in [i-(k-1), i]
             */
            queue.offer(i); // queue contains the index... maxWindow contains the actual number

            /*
                If the current index is greater or equal to the window size (in this case 3 - 1 = 2,
                add the current max number from the queue to the maxWindow array
            */
            if(i >= k - 1)
                /*
                    Queue contains the index... maxWindow result array contains the actual number

                    At each step the head of the deque is the max element in [i-(k-1),i]
                */
                maxWindow[currentMaxIndex++] = nums[queue.peek()];
        }
        return maxWindow;
    }

    public static void main(String[] args) {
        System.out.print("Max Sliding Window : ");
        System.out.print("[");
        for(int i : maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)) {
            System.out.print(" " +i);
        }
        System.out.print(" ]");
    }
}
