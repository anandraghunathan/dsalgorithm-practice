package com.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCommonCharacters {
    public static List<String> commonChars(String[] A) {
        Map<Character, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for(String word : A) {
            for(int i = 0; i < word.length(); i++) {
                map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);
            }
        }

        for(Character c : map.keySet()) {
            System.out.println("key: " + c +" value : "+map.get(c));
            int keyCount = map.get(c);
            if(keyCount >= A.length) {
                list = commonChars(list, c, A.length, keyCount);
            }
        }
        return list;
    }

    private static List<String> commonChars(List<String> list, Character c, int arrCount, int keyCount) {
        while(keyCount >= arrCount) {
            list.add(Character.toString(c));
            keyCount = keyCount - arrCount;
        }

        if(keyCount >= arrCount && keyCount % arrCount == 0)
            commonChars(list, c, arrCount, keyCount);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(commonChars(new String[]{"bella","label","roller"}));
    }
}
