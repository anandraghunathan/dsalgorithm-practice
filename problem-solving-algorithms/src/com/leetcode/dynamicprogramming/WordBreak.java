package com.leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/word-break/

/** Time: O(n ^ 2) for the two loops. Add another O(n) for the substring for corresponding counters.
 *  Space: O(n)
  */
public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak("", wordDict));
    }
}
