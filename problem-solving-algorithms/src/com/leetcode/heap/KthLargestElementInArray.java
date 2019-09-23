package com.leetcode.heap;

import java.util.PriorityQueue;

/**
 *  Solved on May 15 2019, modified on Sep 20 2019
 *
 *  https://leetcode.com/problems/kth-largest-element-in-an-array
 *
 *  Time  : O(N log K).
 *
 *          This is due the fact that the PriorityQueue is implemented as a Binary Heap, which in fact is
 *          nothing more then complete binary tree. So both inserting and removing the values through offer() and
 *          poll() methods have O(log K) complexity and altogether since you doing this operation N times the total
 *          complexity is O(N log K).
 *
 *  Space : O(1), constant space cause we don't use any extra space.
 *
 *  TODO - Quick select approach
 */
public class KthLargestElementInArray {
    public static int findKthLargest(int[] nums, int k) {

        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val : nums) {
            pq.offer(val);

            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4));
    }
}
