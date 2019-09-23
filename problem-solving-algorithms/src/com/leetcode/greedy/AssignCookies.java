package com.leetcode.greedy;

import java.util.Arrays;

public class AssignCookies {
    /**
     *
     *  Brute force - O(n ^ 2) time with constant space
     */
    public int findContentChildrenBrute(int[] g, int[] s) {
        // Only when we sort the arrays, we get the right result
        Arrays.sort(g);
        Arrays.sort(s);
        int contentChildren = 0;
        for(int i = 0; i < g.length; i++) {
            for(int j = 0; j < s.length; j++) {
                if(g[i] <= s[j]) { // When the greed is less or equal to the size of the cookie, increment the res
                    contentChildren += 1;
                    s[j] = 0; // Make the current cookie size we just processed to 0 so that it doesn't get processed again
                    break; // break when we found the candidate cause there is no need to keep on looking
                }
            }
        }
        return contentChildren;
    }

    /**
     *  Could be called as a greedy approach - Two pointers. No need to loop through twice.
     *
     *  Time  : O(mlogm + nlogn + n) - O(N log N), cause we are sorting the two arrays and going through the iteration
     *          once pass.
     *  Space : O(1)
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int contentChild = 0;
        for(int cookieSize = 0; contentChild < g.length && cookieSize < s.length; cookieSize++) {
            if(g[contentChild] <= s[cookieSize]) {
                contentChild++;
            }
        }
        return contentChild;
    }

    public static void main(String[] args) {
        AssignCookies obj = new AssignCookies();
        System.out.println("Content Children : " +obj.findContentChildren(new int[]{1,2,3}, new int[]{3}));
    }
}
