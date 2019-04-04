package com.leetcode.string;

public class HowManyPalindromicSubstring {
    static int count = 0;
    public static int countSubstrings(String s) {
        int len = s.length();
        for(int i = 0; i < len; i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i+1);
        }
        return count;
    }

    private static void extendPalindrome(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }
}
