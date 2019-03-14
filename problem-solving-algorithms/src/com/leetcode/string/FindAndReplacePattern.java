package com.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> matched = new ArrayList<>();
        for(String word : words) {
            if(match(word, pattern))
                matched.add(word);
        }
        return matched;
    }

    public static boolean match(String word, String pattern) {
        Map<Character, Character> wordPatternMap = new HashMap<>();
        for(int i = 0; i < word.length(); i++) {
            char wordChar = word.charAt(i);
            char patternChar = pattern.charAt(i);

            if(!wordPatternMap.containsKey(wordChar)) {
                wordPatternMap.put(wordChar, patternChar);
            }

            if(wordPatternMap.get(wordChar) != patternChar)
                return false;

        }
        boolean[] seen = new boolean[26];
        for(char p : wordPatternMap.values()){
            if(seen[p - 'a'])
                return false;
            seen[p - 'a'] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(findAndReplacePattern(new String[]{"dkd","ccc", "abc","deq","mee","aqq"}, "abb"));
    }
}
