package com.leetcode.greedy;

/** https://leetcode.com/problems/longest-palindrome/solution/ */
public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        /*
            Solve using greedy approach where we find as many partnered letters
            as possible with a unique center. For example, abcba, 'aa' and 'bb'
            are partners with a unique center 'c' that forms a palindrome
        */

        /*
            Int array that will have the count (number of times repeated) corresponding
            to the ASCII code of each alphabet
        */
        int[] count = new int[128];
        for(char c : s.toCharArray()) {
            count[c]++;
        }
        int ans = 0;
        for(int alphabetCount : count) {
            ans += alphabetCount / 2 * 2;

            /*
                1. The first "ans % 2 == 0", checks if the answer var is an even number,
                if it is, then does the second check
                2. The second "alphabetCount % 2 == 1", checks if the current alphabet
                count is an odd number, so that it can be added as a unique
                center for the palindrome partnered letters
            */
            if(ans % 2 == 0 && alphabetCount % 2 == 1)
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abbccccdd"));
    }
}
