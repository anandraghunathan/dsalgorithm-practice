package com.leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/decode-ways
 *
 * Runtime  : O(n)
 * Space    : O(1)
 */
public class DecodeWays {
    public static int numDecodings(String s) {
        if(s.length() == 0 || s == null)
            return 0;

        int n = s.length();

        // n + 1 will save the addition of all the sub-problems in the last index of the dp array
        int[] dp = new int[n + 1];

        // When the given string is empty, it means an empty string will have one way to decode
        dp[0] = 1;

        /*
            IF the input string given is not "0", it means there will have one way to decode
            IF the input string given is "0", then return 0.
        */
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        // The logic is to pick first digit, then the next two digits during each iteration
        for(int i = 2; i <= n; i++) {

            // To get the first digit of the input string during the current iteration
            int firstDigit = Integer.valueOf(s.substring(i - 1, i));

            // To get the next two digits of the input string during the current iteration
            int secondDigitWithPreviousDigit = Integer.valueOf(s.substring(i - 2, i));

            // If first digit, add the number of decoding ways for the corresponding digit obtained
            if(firstDigit >= 1 && firstDigit <= 9)
                dp[i] += dp[i - 1];

            // To deal with the second and third digits
            if(secondDigitWithPreviousDigit >= 10 && secondDigitWithPreviousDigit <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("2213"));
    }
}
