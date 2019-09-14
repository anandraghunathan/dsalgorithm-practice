package com.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;

public class DistributeCandies {
    /**
     *
     * Time  : O(N log N), we are calling the sort function and computing count in one-pass
     * Space : O(1), constant space
     */
    public int distributeCandies(int[] candies) {
        int count = 1;
        Arrays.sort(candies);

        for(int i = 1; i < candies.length && count < candies.length / 2; i++) {
            if(candies[i] > candies[i - 1]) {
                count++;
            }
        }
        return count;
    }

    /**
     *
     * HashSet approach
     *
     * Time  : O(N), one-pass
     * Space : O(N), Set used to store candies
     */
    public int distributeCandiesSet(int[] candies) {
        HashSet<Integer> set = new HashSet();
        for(int candy : candies) {
            set.add(candy);
        }
        return Math.min(set.size(), candies.length / 2);
    }

    public static void main(String[] args) {
        DistributeCandies obj = new DistributeCandies();
        //System.out.println(obj.distributeCandies(new int[]{1,1,2,3}));
        System.out.println(obj.distributeCandiesSet(new int[]{1,1,2,2,3,3}));
    }
}
