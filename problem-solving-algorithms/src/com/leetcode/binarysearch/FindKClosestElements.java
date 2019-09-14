package com.leetcode.binarysearch;

import java.util.ArrayList;
import java.util.List;

/**
 *  Intuition
 *      The array is sorted. If we want to find the one number closest to x, we don't have to check one by one.
 *      We can use binary research. Now we want the k closest, the logic is the similar.
 *
 *  Explanation:
 *      Assume we are taking A[i] ~ A[i + k -1]. We can binary research i. We compare the distance between
 *      x - A[mid] and A[mid - k] - x
 *
 *      If x - A[mid] > A[mid + k] - x, it means A[mid + 1] ~ A[mid + k] is greater than A[mid] ~ A[mid + k - 1],
 *      and we have mid smaller than the right i. So assign left = mid + 1.
 *
 *   Time  : O(log(N - K)) to do binary research and find the result
 *   Space : O(K), to create the returned list.
 */
public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0, hi = arr.length - k;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (x - arr[mid] > arr[mid + k] - x)
                lo = mid + 1;
            else
                hi = mid;
        }
        List<Integer> res = new ArrayList<>(k);
        for (int i = lo; i < hi + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        FindKClosestElements obj = new FindKClosestElements();
        List<Integer> res = obj.findClosestElements(new int[]{1,2,3,4,5,6,7,8}, 4, 6);
        //List<Integer> res = obj.findClosestElements(new int[]{1,2,3,4,5}, 4, 1);
        //List<Integer> res = obj.findClosestElements(new int[]{1,2,3,4,5}, 4, 3);
        //List<Integer> res = obj.findClosestElements(new int[]{1,2,3,4,5}, 4, -1);
        int resCount = res.size();
        System.out.print("[");
        for(int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
            System.out.print(resCount-- > 1 ? ", " : "");
        }
        System.out.print("]");
    }
}
