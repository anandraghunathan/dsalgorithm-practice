package com.leetcode.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *  https://leetcode.com/problems/find-k-pairs-with-smallest-sums
 *
 *  Intuition & Algorithm
 *      Use min_heap to keep track on next minimum pair sum, and we only need to maintain K possible candidates in the
 *      data structure.
 *
 *      Some observations: For every numbers in nums1, its best partner(yields min sum) always starts from nums2[0] since
 *      arrays are all sorted; And for a specific number in nums1, its next candidate should be,
 *          [this specific number] + nums2[current_associated_index + 1], unless out of boundary;)
 *
 *  Time  : K(log K), only add K elements into the heap, adding and retrieval from the list are all O(1) operation
 *  Space : O(K), worse case, we store K elements in the list
 */
public class FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(
                (a,b) -> (a.get(0) + a.get(1)
                        - (b.get(0) + b.get(1)))
        );
        List<List<Integer>> res = new ArrayList<>(); // result list that we will return

        // Check for null conditions. K can't be 0, also nums1 and nums2 can't be 0, if either is, return empty list
        if(nums1.length == 0 || nums2.length == 0 || k == 0)
            return res;

        /*
            Step 1 - To start, add nums1's all elements and the first index element of nums2 into the minHeap.

            Min heap will in turn do the sorting of smallest sums pair on top to max sums pair at the bottom
        */
        for(int i = 0; i < nums1.length; i++) {

            List<Integer> temp = new ArrayList<>(); // Temp list that we will add to the minHeap

            temp.add(nums1[i]); // add all the elements in the nums1 array from 1st index to last
            temp.add(nums2[0]); // add the first index element from nums2 sorted array, so smaller comes first
            temp.add(0); // used as the index to denote the current index of the nums2 index

            minHeap.offer(temp); // add the temp list to the minHeap
        }

        // Step 2 - Now we have to form the result by pairing one element from nums1 and another from nums2
        // We only need K pairs, so we add k-- > 0 condition
        while(k-- > 0 && !minHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            List<Integer> currPairFromHeap = minHeap.poll();
            temp.add(currPairFromHeap.get(0)); // Take the first element of the pair
            temp.add(currPairFromHeap.get(1)); // Take the second element of the pair
            res.add(temp); // Add the current result we constructed to the res list

            /*
                Step 3 - Now we have to explore the nums2 array elements since we only added the first index
                element in Step 1. So here, we explore the other numbers that could constitute a smaller pair
                that will again be added to the minHeap like in Step 1

                So, we take current num pair that we got from polling from the heap, take the current first
                index. Then we add the next num present in nums2 based on the index (temp.add(0)) we added
                as part of the pair in Step 1, add the pair back into the minHeap

                Everytime, we add a new element from the pair, we increment the index and add it back into
                the minHeap.
            */

            // See if the current pair's index is within the size of the array
            if(currPairFromHeap.get(2) == nums2.length - 1)
                continue;

            List<Integer> newTemp = new ArrayList<>(); // To consititute the next pair element from nums2

            newTemp.add(currPairFromHeap.get(0)); // Take the first element of the current pair

            // Take the second element from nums2 based on the current pair's index added as part of Step 1
            // If if the current pair's index is 0, we will add nums[0 + 1], so second element from nums2
            newTemp.add(nums2[currPairFromHeap.get(2) + 1]);
            newTemp.add(currPairFromHeap.get(2) + 1); // Increment this pair's index to currentPair index + 1

            // Add the newly constructed pair into the minHeap for finding the smaller sum
            minHeap.offer(newTemp);
        }
        return res; // return the final res list with all the smaller pairs based on the given k
    }

    public static void main(String[] args) {
        FindKPairsWithSmallestSums obj = new FindKPairsWithSmallestSums();
        List<List<Integer>> res = obj.kSmallestPairs(new int[]{1,7,11,16}, new int[]{2,9,10,15}, 4);
        System.out.print("[");
        for(List<Integer> pairs : res) {
            System.out.print("[");
            System.out.print(pairs.get(0));
            System.out.print(", ");
            System.out.print(pairs.get(1));
            System.out.print("]");
        }
        System.out.print("]");
    }
}
