package com.leetcode.string;

public class ValidPalindrome {
    /*
     * https://leetcode.com/problems/valid-palindrome/
     *
     * Traverse the String by having two pointers head and tail, one from left to right
     * and the other from right to left. Ignore the special characters that are not letters
     * or digits. When a character is found, check if left and right are the same by converting
     * into lowercase, otherwise return false.
     */
    public static boolean isPalindrome(String s) {
        int n = s.length() - 1;

        if(s.length() == 0)
            return true;

        int lo = 0;
        int hi = n;

        while(lo <= hi) {
            if(Character.toLowerCase(s.charAt(lo)) == Character.toLowerCase(s.charAt(hi))) {
                lo++;
                hi--;
            } else if(!Character.isLetterOrDigit(s.charAt(lo))) {
                lo++;
            } else if(!Character.isLetterOrDigit(s.charAt(hi))) {
                hi--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("\"A man, a plan, a canal: Panama\""));
    }
}
