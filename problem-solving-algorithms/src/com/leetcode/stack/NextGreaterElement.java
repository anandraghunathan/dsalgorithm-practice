package com.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *  Intuition:
 *      Similar to https://leetcode.com/problems/daily-temperatures/
 *
 *      Suppose we have a decreasing sequence followed by a greater number. For example [5, 4, 3, 2, 1, 6] then the
 *      greater number 6 is the next greater element for all previous numbers in the sequence
 *
 *      We use a stack to keep a decreasing sub-sequence, whenever we see a number x greater than stack.peek(), we pop
 *      all elements less than x and for all the popped ones, their next greater element is x
 *
 *      For example - [9, 8, 7, 3, 2, 1, 6]
 *      The stack will first contain [9, 8, 7, 3, 2, 1] and then we see 6 which is greater than 1, so we pop 1 2 3 whose
 *      next greater element should be 6
 *
 *  Time  : O(N), one pass to store the next element mapping O(M), and one-pass to return the output based on the mapping O(N).
 *          So its O(M + N). And each element only gets pushed and popped to and from the stack at most once.
 *  Space : O(N), worst case, the HashMap can have N mapping for all the elements between the two arrays
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap();
        Stack<Integer> stack = new Stack();

        /*
            Since the question asked is, "Find all the next greater numbers for nums1's elements in the corresponding
            places of nums2.", we do the following,
                Push nums2 elements into the map with a condition that the current element in the stack is less than the
                current num in the iteration
        */
        for(int num2 : nums2) {
            while(!stack.isEmpty() && stack.peek() < num2) {
                map.put(stack.pop(), num2);
            }
            stack.push(num2);
        }

        /*
            If the current num of nums1 is present in the map, it means it has a corresponding next greater number
            that was available in the nums2 array. If not, -1 is returned.
            The same nums1 array is modified with the output
         */
        for(int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }

    /**
     *
     *  Brute force.
     *
     *  Time  : O(N ^ 2)
     *  Space : O(N)
     */
    public int[] nextGreaterElementBruteForce(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for(int i = 0 ; i < nums1.length; i++) {
            ans[i] = -1;
            boolean found = false;

            for(int j = 0; j < nums2.length; j++) {
                if(found & nums2[j] > nums1[i] ) {
                    ans[i] = nums2[j];
                    break;
                }

                if(nums2[j] == nums1[i]) {
                    found = true;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        NextGreaterElement obj = new NextGreaterElement();
        //int[] resArr = obj.nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2});
        int[] resArr = obj.nextGreaterElement(new int[]{1,3,5,2,4}, new int[]{6,5,4,3,2,1,7});
        int resCount = resArr.length;

        // Printing output
        System.out.print("[");
        for(int res : resArr) {
            System.out.print(res);
            System.out.print(resCount-- > 1 ? " ," : "");
        }
        System.out.print("]");
    }
}
