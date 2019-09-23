package com.leetcode.heap;

import java.util.*;

/**
 *  Solved on 27th May 2019
 *
 *  https://leetcode.com/problems/top-k-frequent-elements
 *
 *  Time  : O(Nlog(k)). The complexity of Counter method is O(N). To build a heap and output list takes O(N log(k)).
 *          Hence the overall complexity of the algorithm is O(N + Nlog(k))=O(N log(k)).
 *  Space : O(N), to store the hash map.
 *
 */
public class TopKFrequentElements {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        // Count the number of occurrences of each element in the array using hashtable
        Map<Integer, Integer> count = new HashMap<>();
        for(int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Initializing the heap. Less Frequent element first. Then the most frequent element.
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));
        for(int num : count.keySet()) {
            heap.add(num);
            if(heap.size() > k)
                heap.poll();
        }

        // Build the output list that will contain the top frequent elements based on the input k
        List<Integer> topk = new ArrayList<>();
        while(!heap.isEmpty())
            topk.add(heap.poll());
        Collections.reverse(topk);
        return topk;
    }

    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{1,2,2,3,3}, 2));
    }
}
