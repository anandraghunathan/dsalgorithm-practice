package com.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Runtime: O(2n) = O(n)O(2n)=O(n). In the worst case each character will be visited twice by i and j.
     * Space O(min(m, n)) - We need O(k) space for the sliding window, where k is the size of the set.
     * The size of the set is upper bounded by the size of the string n and the size of the charset/alphabet m.
     */
    public static int lengthOfLongestSubstringSet(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * Runtime: O(n).
     * Space O(min(m, n)) - We need O(k) space for the sliding window, where k is the size of the map.
     * The size of the map is upper bounded by the size of the string n and the size of the charset/alphabet m.
     */

    public static int lengthOfLongestSubstringMap(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    /**
     * Runtime: O(n).
     * Space:  O(m). m is the size of the charset.
     */
    public static int lengthOfLongestSubstringASCII(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        //System.out.println(lengthOfLongestSubstringSet("abcabcbb"));
        System.out.println(lengthOfLongestSubstringMap("abcabcbb"));
        //System.out.println(lengthOfLongestSubstringASCII("abcabcbb"));
    }
}
