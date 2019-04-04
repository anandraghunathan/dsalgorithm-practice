package com.leetcode.array;

import java.util.PriorityQueue;

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
        System.out.println(findKthLargest(new int[] {2,1,5,6,4}, 2));
    }
}
