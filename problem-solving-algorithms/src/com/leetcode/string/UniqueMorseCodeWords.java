package com.leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {
    public static int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[] {".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-",
                "...-",".--","-..-","-.--","--.."};
        Set<String> unique = new HashSet<>();
        for(String word : words) {
            StringBuilder code = new StringBuilder();
            for(char array: word.toCharArray()) {
                code.append(morse[array - 'a']);
            }
            unique.add(code.toString());
        }
        return unique.size();
    }

    public static void main(String[] args) {
        uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"});
    }
}
