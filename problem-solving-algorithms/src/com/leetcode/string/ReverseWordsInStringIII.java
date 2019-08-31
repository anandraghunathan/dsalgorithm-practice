package com.leetcode.string;

public class ReverseWordsInStringIII {
    public String reverseWords(String s) {
        String[] words = new String[s.length()];
        StringBuilder sb = new StringBuilder();
        words = s.split(" ");
        int len = words.length;
        for(String word : words) {
            len--;
            char[] c = word.toCharArray();
            for(int i = c.length - 1; i >= 0; i--) {
                sb.append(c[i]);
                if(i == 0 && len != 0)
                    sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInStringIII obj = new ReverseWordsInStringIII();
        System.out.println(obj.reverseWords("Let's take LeetCode contest"));
    }
}
