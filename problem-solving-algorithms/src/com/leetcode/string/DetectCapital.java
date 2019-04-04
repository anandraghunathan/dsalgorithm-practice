package com.leetcode.string;

public class DetectCapital {
    public static boolean detectCapitalUse(String word) {
        int cnt = 0;
        for(char c : word.toCharArray()) {
            if('Z' - c >= 0)
                cnt++;
        }
        return((cnt == 0 || cnt == word.length()) || (cnt == 1 && 'Z' - word.charAt(0) > 0));
    }

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("gooGle"));
    }
}
