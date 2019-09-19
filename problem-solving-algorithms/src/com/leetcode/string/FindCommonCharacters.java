package com.leetcode.string;

import java.util.*;

public class FindCommonCharacters {
    /**
     *
     * Faster, arrays approach with fewer iteration
     *
     * https://leetcode.com/problems/find-common-characters/discuss/247573/C++-O(n)-or-O(1)-two-vectors/243242
     *
     */
    public static List<String> commonCharsFaster(String[] A) {
        int[] charset = new int[26]; // only lowercase letters
        Arrays.fill(charset, Integer.MAX_VALUE);
        for (String str : A) {
            int[] count = buildCharFrequencyTable(str);
            for (int i = 0 ; i < charset.length; i++) {
                charset[i] = Math.min(charset[i], count[i]);
            }
        }
        return toList(charset);
    }

    private static List<String> toList(int[] charset) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < charset.length; i++) {
            for (int sz = charset[i]; sz > 0; sz--) {
                result.add("" + (char) (i + 'a'));
            }
        }
        return result;
    }

    private static int[] buildCharFrequencyTable(String str) {
        int[] count = new int[26];
        for (char c : str.toCharArray()) {
            count[c - 'a']++;
        }
        return count;
    }
    /**
     *
     * Two hashmap approach - Slow, multiple looping, and more space
     *
     */
    public List<String> commonCharsTwoHashMap(String[] A) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        List<String> res = new ArrayList<>();

        for(String str : A) {
            HashMap<Character, Integer> map2 = new HashMap<>();
            for(char c : str.toCharArray()) {
                map2.put(c, map2.getOrDefault(c, 0) + 1);
            }

            if(map1.isEmpty()) {
                for(Character c : map2.keySet()) {
                    map1.put(c, map2.get(c));
                }
            } else {
                for(Character c : map1.keySet()) {
                    int val = map2.getOrDefault(c, 0);
                    map1.put(c, Math.min(val, map1.get(c)));
                }
            }
        }

        for(Character c : map1.keySet()) {
            for(int i = 1; i <= map1.get(c); i++) {
                res.add(String.valueOf(c));
            }
        }
        return res;
    }
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
