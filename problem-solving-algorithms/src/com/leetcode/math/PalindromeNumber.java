package com.leetcode.math;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        int palindrome = 0;
        int input = x;
        while (x != 0 && x % 10 != 0) {
            int pop = x % 10;
            x /= 10;
            palindrome = palindrome * 10 + pop;
        }
        if(input == palindrome) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(0100));
    }
}
