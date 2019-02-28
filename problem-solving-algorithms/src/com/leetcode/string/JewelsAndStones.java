package com.leetcode.string;

import java.util.HashSet;

public class JewelsAndStones {

    public static void main(String[] args) {
        JewelsAndStones js = new JewelsAndStones();
        System.out.println("Output: " +js.numJewelsInStones("aA", "aAAbbbb"));
    }

//    int numJewelsInStones(String J, String S) {
//        char[] jewels = J.toCharArray();
//        char[] stones = S.toCharArray();
//        int stonesThatAreJewels = 0;
//        for(int x=jewels.length-1; x>=0; x--) {
//            for (int y=stones.length-1; y>=0; y--) {
//                if(jewels[x] == stones[y]) {
//                    stonesThatAreJewels = stonesThatAreJewels + 1;
//                }
//            }
//        }
//        return stonesThatAreJewels;
//    }

    int numJewelsInStones(String J, String S) {
        HashSet<Character> jewels = new HashSet<>();
        for(char c : J.toCharArray()) {
            jewels.add(c);
        }

        int counter = 0;
        for(int i = 0; i < S.length(); i++) {
            if(jewels.contains(S.charAt(i))) {
                counter++;
            }
        }
        return counter;
    }
}
