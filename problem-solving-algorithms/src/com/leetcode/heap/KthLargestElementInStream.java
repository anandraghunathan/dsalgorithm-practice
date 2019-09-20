package com.leetcode.heap;

import java.util.PriorityQueue;

/**
 *  Solved on Sep 20 2019
 *
 *  https://leetcode.com/problems/kth-largest-element-in-a-stream/
 *
 *  We can build a MinHeap that contains only k largest elements.
 *
 *  On add: Compare a new element x with min to decide if we should pop min and insert x take into account a case when
 *  heap_size is less than k
 *
 * Time  : Construction: O(N), Construction is simply calling the add function N times.
 *         Adding elements into PQ: O(log K)
 *         So, O(N * log K)
 *
 * Space : O(K) (can be reduced to O(1) by reusing memory of the existing array)
 */
public class KthLargestElementInStream {
    PriorityQueue<Integer> pq = null;
    int k;

    public KthLargestElementInStream(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k); // Define the priority queue (minHeap by default in Java) only for k elements

        // Iterate through the given array and add each element using the add method we implemented here.
        for(int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        pq.offer(val);

        // Poll the top (minimum) element when the current size of the queue is greater than the given k
        if(pq.size() > k)
            pq.poll();

        return pq.peek(); // If we peek, the top element of the queue will be our result
    }

    public static void main(String[] args) {
        int k = 3; int[] nums = {4,5,8,2};
        KthLargestElementInStream obj = new KthLargestElementInStream(k, nums);
        System.out.print("[");
        System.out.print(obj.add(3)); System.out.print(", ");
        System.out.print(obj.add(5)); System.out.print(", ");
        System.out.print(obj.add(10)); System.out.print(", ");
        System.out.print(obj.add(9)); System.out.print(", ");
        System.out.print(obj.add(4));
        System.out.print("]");
    }
}
