package com.leetcode.string;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class RemoveDuplicateCharacterInString {

    public static String removeDuplicateCharacter(String input) {
        HashSet<Character> setChars = new LinkedHashSet();
        for(Character c : input.toCharArray()) {
            setChars.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for(Character c : setChars) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateCharacter("goodmorning"));
    }
}


