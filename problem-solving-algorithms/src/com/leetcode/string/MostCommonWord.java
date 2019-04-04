package com.leetcode.string;

import java.util.*;

public class MostCommonWord {
    public static String mostCommonWord(String paragraph, String[] banned) {
        String[] para = paragraph.toLowerCase()
                .replaceAll("\\W+", " ").split(" ");
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for(String ban : banned)
            set.add(ban);

        int ansCount = 0;
        String ans = "";
        for(int i = 0; i < para.length; i++) {
            if(!set.contains(para[i])) {
                System.out.print(para[i] + " ");
                int paraCount = map.getOrDefault(para[i], 0) +1;
                map.put(para[i], paraCount);

                if(paraCount > ansCount) {
                    ans = para[i];
                    ansCount = paraCount;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("\nMost Common Word is - " +
                mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"}));
    }
}
