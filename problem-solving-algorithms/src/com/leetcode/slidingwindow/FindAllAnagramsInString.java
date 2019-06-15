package com.leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInString {
    public static List<Integer> findAnagrams(String s, String p) {
        int[] chars = new int[26];
        List<Integer> res = new ArrayList<>();

        // Check null and empty
        if(s == null || p == null || s.length() == 0 || p.length() == 0)
            return res;

        // Add the characters in p to the int array
        for(char c : p.toCharArray())
            chars[c - 'a']++;

        int start = 0, end = 0, count = p.length();

        while(end < s.length()) {
            // If the character at the start of s appeared in p, we increase count
            if(end - start == p.length() && chars[s.charAt(start++) - 'a']++ >= 0)
                count++;

            // If the char at end of s appeared in p (since it's not -1 after decreasing), we decrease count
            if(--chars[s.charAt(end++) - 'a'] >= 0)
                count--;

            // If the count is zero after the above two steps, it means we found the start of the anagram index
            if(count == 0)
                res.add(start);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
