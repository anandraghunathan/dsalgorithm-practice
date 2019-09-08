package com.leetcode.string;

public class IsomorphicStrings {
    /**
         https://leetcode.com/problems/isomorphic-strings/

         Intuition:
             The main idea is to store the last seen positions of current (i-th) characters in both strings.
             If previously stored positions are different, then we know that the fact they're occuring in the
             current i-th position simultaneously is a mistake. We could use a map for storing but as we deal
             with chars which are basically ints and can be used as indices we can do the whole thing with
             array.

         Algorithm:
             So we use two arrays here arrS and arrT, initialized space is 256 (Since the whole ASCII size
             is 256, 128 also works here). Traverse the character of both s and t on the same position, if
             their mapping values in arrS and arrT are different, means they are not mapping correctly, so
             return false; else we construct the mapping, since arrS and arrT are both initialized as 0,
             we want to use a new value when i == 0, so current i and we do a +1 to it.

        Time  : O(N) = O(Length of the string), N is tehe length of the given string
        Space : O(1). Constant space
     */
    public boolean isIsomorphic(String s, String t) {
        /*
            There are 256 ASCII characters. This includes standard ASCII characters (0-127)
            and Extended ASCII characters (128-255).
        */
        int[] arrS = new int[128];
        int[] arrT = new int[128];

        for(int i = 0; i < s.length(); i++) {
            // When the count corresponding to arr indices at s and t are not same, the strings are not isomorphic
            if(arrS[s.charAt(i)] != arrT[t.charAt(i)]) {
                return false;
            }
            /*
                Else we add the current index +1 to the arr indices of s and t corresponding to the current character
                at each given string
            */
            arrS[s.charAt(i)] = i +1;
            arrT[t.charAt(i)] = i +1;
        }
        return true; // return true as the condition will reach here only if the two strings are isomorphic
    }

    public static void main(String[] args) {
        IsomorphicStrings obj = new IsomorphicStrings();
        System.out.println(obj.isIsomorphic("paper", "title"));
    }
}
