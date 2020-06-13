package com.leetcode.array;

import java.util.HashSet;

public class SmallestNextPositiveNumber {
    /*
        Runtime: O(N)
        Space  : O(N)
     */
    public static int searchInUnsortedArray1(int[] A) {
        // Default smallest Positive Integer
        int smallest = 1;

        // Store values in set which are greater than variable smallest
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            // Store the value in the set when the smallest is less than value at the current index of given array
            if (smallest < A[i]) {
                set.add(A[i]);
            }
            else if (smallest == A[i]) {
                // Increment smallest when it is equal to current element
                smallest = smallest + 1;

                while (set.contains(smallest)) {
                    set.remove(smallest);

                    // Increment smallest when it is one of the elements of the set
                    smallest = smallest + 1;
                }
            }
        }
        // Return the result
        return smallest;
    }

    /*
        Better Space complexity cause no extra space used

        Runtime: O(N)
        Space  : O(1)
     */
    public static int searchInUnsortedArray2(int[] arr) {
        // to store current array element
        int val;

        // to store next array element in
        // current traversal
        int nextval;

        int n = arr.length;

        for (int i = 0; i < n; i++) {

            // if value is negative or greater
            // than array size, then it cannot
            // be marked in array. So move to
            // next element.
            if (arr[i] <= 0 || arr[i] > n)
                continue;

            val = arr[i];

            // traverse the array until we
            // reach at an element which
            // is already marked or which
            // could not be marked.
            while (arr[val - 1] != val) {
                nextval = arr[val - 1];
                arr[val - 1] = val;
                val = nextval;
                if (val <= 0 || val > n)
                    break;
            }
        }

        // find first array index which is
        // not marked which is also the
        // smallest positive missing
        // number.
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        // if all indices are marked, then
        // smallest missing positive
        // number is array_size + 1.
        return n + 1;
    }

    public static void main(String[] args) {
//        System.out.println(searchInUnsortedArray2(new int[]{1, 3, 6, 4, 1, 2}));
//        System.out.println(searchInUnsortedArray2(new int[]{1, 2, 3}));
        System.out.println(searchInUnsortedArray2(new int[]{-1, -3, 3, 4}));
    }
}
