package com.leetcode.heap;

import java.util.PriorityQueue;

/**
 *  Solved on Sep 20 2019
 *
 *  https://leetcode.com/problems/last-stone-weight
 *
 *  Time  : O(N log N), we do log N operations (poll and offer into the maxHeap) N times.
 *  Space : O(N), at most we will have N all the given stone array elements in maxHeap after the first for loop
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        // Max Heap to store the stones in decreasing order
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);

        // Add each stone into the maxHeap
        for(int stone : stones) {
            maxHeap.offer(stone);
        }

        /*
            Iterate till we have one element in the maxHeap,
                   1. Each time, poll two times to get the largest two stones,
                   2. Add the difference between those large stones back into the maxHeap
        */
        while(maxHeap.size() > 1) {
            int elem1 = maxHeap.poll();
            int elem2 = maxHeap.peek() == null ? 0 : maxHeap.poll();
            maxHeap.offer(elem1 - elem2);
        }
        // Finally return the last single stone standing
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        LastStoneWeight obj = new LastStoneWeight();
        System.out.println(obj.lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }
}
