package com.leetcode.string;

/**
 * https://leetcode.com/problems/longest-common-prefix
 */
public class LongestCommonPrefix {
    /*
        Vertical scanning of the string.
        We compare characters from top to bottom on the same column (same character index of the strings) before moving on to the next column.
        Example: Input --> str[] = {"flower", "flow", "flight"}, take 'f' from str[0], compare it
        with first index of str[1] and str[2], then take 'l', repeat the same process and so on
    */
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 || strs == null)
            return "";

        // Consider the first column of the string array
        for(int i = 0; i < strs[0].length(); i++) {

            // Consider the first index of the first column of the string array
            char c = strs[0].charAt(i);

            // Start from the second column till the end of the string array to check for the common prefix
            for(int j = 1; j < strs.length; j++) {
                /* When the column's length is equal to i or character found at the corresponding index is not equal to the character found in the first step of the previous loop, return the substring from 0 till the current index i */
                if(strs[j].length() == i || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        //System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"aa","a"}));
    }
}
