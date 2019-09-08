package com.leetcode.string;

public class ValidPalindromeII {
    /**
         https://leetcode.com/problems/valid-palindrome-ii/

         Intuition:
         Follow normal way (two pointers) to check if s is palindrome. When two chars are not equal,
         try to skip (pseudo delete) either left one or right one and continue checking.

         Algorithm:
         We first have two pointers. One start from 0, other from the end, we check if the two chars are
         equal, if yes, we keep incrementing the lo and decrementing the high. Once we hit a char pair
         that don't match, we do a pseudo delete by skipping either decrementing the hi or incrementing
         lo to check if the rest of the string can be a palindrome. If the char at current lo and
         current hi are not the same even after doing the pseudo delete (by skipping one char), then
         we can conclude that the partial string can't be a palindrome.

        Time  : O(N), N is the number of characters in the string. Each of two checks of whether some substring is a
                palindrome is O(N)
        Space : O(1), we use constant space by using only pointers
     */
    public boolean validPalindrome(String s) {
        int lo = 0;
        int hi = s.length() - 1;

        while(lo <= hi) {
            // If the char at the two pointer are equal, just move the pointers
            if(s.charAt(lo) == s.charAt(hi)) {
                lo++;
                hi--;
            } else {
                // If not equal, skip (pseudo delete) one char to check if partial string is a palindrome
                // First call is to handle cases like "abca"
                // Second call is to handle cases like "dee"
                return isPalindrome(s, lo, hi - 1) || isPalindrome(s, lo + 1, hi);
            }
        }
        return true;
    }

    // Helper function to check if the skipped and partial string is a palindrome
    private boolean isPalindrome(String s, int lo, int hi) {
        while(lo <= hi) {
            if(s.charAt(lo) == s.charAt(hi)) {
                lo++;
                hi--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindromeII obj = new ValidPalindromeII();
        //System.out.println(obj.validPalindrome("abca"));
        System.out.println(obj.validPalindrome("dee"));
    }
}
