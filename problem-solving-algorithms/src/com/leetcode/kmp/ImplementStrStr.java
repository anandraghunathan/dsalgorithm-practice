package com.leetcode.kmp;

/**
 * Created by Anand Raghunathan on 2019-08-27
 *
 * https://leetcode.com/problems/implement-strstr/
 *
 * Perform KMP Search
 *
 * Time  : O(M + N), where M is the length of the text and N is the length of the pattern
 * Space : O(N), the longest prefix that is also suffix array we store to compare the text against
 *
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        // Figure out the index using KMP search
        char[] text = haystack.toCharArray();
        char[] pattern = needle.toCharArray();

        int[] longestPrefixAlsoSuffix = computePatternTempArray(pattern);
        int i = 0;
        int j = 0;

        while(i < text.length && j < pattern.length) {
            if(text[i] == pattern[j]) {
                // When a match is found between the text and the patten at the index, just increment i and j
                i++;
                j++;
            } else {
                /*
                    When no match, check if j is at index 0, if not, assign the previous VALUE (present at
                    j - 1) of the longestPrefixAlsoSuffix as the new index of j
                 */
                if(j != 0) {
                    j = longestPrefixAlsoSuffix[j - 1];
                } else {
                    // When no match and j is 0, just increment i to move on the next character in the text
                    i++;
                }
            }
        }
        if(j == pattern.length)
            return i - j;
        else
            return -1;

    }

    private int[] computePatternTempArray(char[] pattern) {
        int[] longestPrefixAlsoSuffix = new int[pattern.length];
        int j = 0;
        for(int i = 1; i < pattern.length;) {
            if(pattern[j] == pattern[i]) {
                /*
                    Since there is a match between the character at j and i of the pattern,
                    we make the array value at index i to the index of where j currently is + 1
                    In other words, we are saying, there is 1 match found between characters at
                    i and j of the pattern, when we find the characters at the next index matching,
                    then j will be one next to the right, so we found two matches.. and so on..

                    And then we increment both i and j to seek for the next comparison from where
                    the match is found.
                 */
                longestPrefixAlsoSuffix[i] = j + 1;
                j++;
                i++;
            } else {
                if(j != 0) {
                    /*
                        Since the there is no match between the character at j and i of the pattern
                        and j is 0, we take assign the value at the index j - 1 of array we are computing
                        In other words, assign the previous value present at j - 1 of the longestPrefixAlsoSuffix
                     */
                    j = longestPrefixAlsoSuffix[j - 1];
                } else {
                    /*
                        Since the there is no match between the character at j and i of the pattern
                        and j is not 0, we make the current value to the index i as 0 and increment i
                     */
                    longestPrefixAlsoSuffix[i] = 0;
                    i++;
                }
            }
        }
        return longestPrefixAlsoSuffix;
    }

    public static void main(String[] args) {
        ImplementStrStr obj = new ImplementStrStr();
        System.out.println(obj.strStr("hello", "ll"));
    }
}
