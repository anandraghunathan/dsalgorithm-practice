package com.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-window-substring
 *
 * https://www.youtube.com/watch?v=eS6PZLjoaq8
 *
 * Time  : O(s + t) - O(n), s is the search string and t is the search keyword (substring)
 * Space : O(s + t) - O(n), s is the search string and t is the search keyword (substring)
 *
 */
public class MinimumWindowSubstring {
    /*
      Sliding Window: Use 2 Pointers To Compose A Sliding Window
    */
    public static String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap();

        // Add all the characters in to be searched string into the HashMap with default value as 0 for all characters
        for(char c : s.toCharArray())
            map.put(c, 0);

        /*
            When a character present in the t string is found in the map, we increment the count corresponding to that
            corresponding character
        */
        for(char c : t.toCharArray()) {
            if(map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                return "";
        }

        // counter represents the number of chars of t to be found in s.
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();

        // Move end to find a valid window.
        while(end < s.length()) {
            char c1 = s.charAt(end);

            // If char in s exists in t, decrease counter
            if(map.get(c1) > 0)
                counter--;
            /*
                Decrease the value of the corresponding char in the map. If char does not exist in t, the following will
                make the value of the corresponding character to be a negative number
             */
            map.put(c1, map.get(c1) - 1);

            // Increment the end at each step
            end++;

            // When we found a valid window, move start to find smaller window. Also calculate the new min window length
            while(counter == 0) {
                if(minLen > end-start) {
                    minLen = end-start;
                    minStart = start;
                }

                // Character at the new start
                char c2 = s.charAt(start);

                // Put the character at the start index back into map, increment the value if already present
                map.put(c2, map.get(c2) + 1);

                // When char count in the map is > 0, increase counter.
                if(map.get(c2) > 0)
                    counter++;

                // Increment the start
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        System.out.println("The Minimum window substring is : " +minWindow("ADOBECODEBANC", "ABC"));
    }



















































    /*
          Sliding Window: Use 2 Pointers To Compose A Sliding Window
          This code passes all Leetcode test cases as of Feb. 21 2019
          Runtime*: 27 ms, faster than 44.99% of Java online submissions for Minimum Window Substring.
          Memory Usage: 35.8 MB, less than 96.11% of Java online submissions for Minimum Window Substring.
          There is a tweak that we can make to make this run faster but it will not change asymptotic
          time complexity so I am satisfied with this for example's sake
    */
    public static String minWindowDetailed(String searchString, String t) {

        // The characters a satisfiable window must cover mapped to their frequency
        Map<Character, Integer> requiredCharacters = buildMappingOfCharactersToOccurrences(t);

        /*
            For our window. Map all characters in the window to their occurrence count. You
            will see how we use this below.
        */
        Map<Character, Integer> windowCharacterMapping = new HashMap<Character, Integer>();

        /*
            2 pointers. Left holds the left index of the window we are inspecting and right
            holds the right index.
            The approach is simple. We keep moving right (don't touch left) until the window
            we hold satisfies all required characters. Then we take note whether the window
            we see beats the smallest satisfiable window we have found so far.
            We then contract the left pointer in while the window still satisfies all required
            characters (at every point continuing to check if we have beaten the smallest window
            ever seen to this point)
            As soon as the window no longer satisfies, go back to expanding the right pointer.
            We are finished when the right pointer runs over the array because we can't keep
            expanding the window to satisfy at that point.
        */
        int left = 0;
        int right = 0;

        /*
            'totalCharFrequenciesToMatch' is the total characters we need to match frequency for
            in the window. If I have 1 'a' in my window and I need 2 'a' chars...then the char
            frequencies don't match.
            'charFrequenciesInWindowThatMatch' is the count of frequencies that we have satisfied.
            When 'totalCharFrequenciesToMatch' == 'charFrequenciesInWindowThatMatch' then it can be
            said that the current window satisfies that property of having all characters with matching
            counts to the string t.
        */
        int totalCharFrequenciesToMatch = requiredCharacters.size();
        int charFrequenciesInWindowThatMatch = 0;

        /*
            We will keep track of the best window we have seen so far
        */
        int minWindowLengthSeenSoFar = Integer.MAX_VALUE;
        String minWindow = "";

        while (right < searchString.length()) {

            /*
                Add the character on the right pointer to the hashtable that maps the characters seen
                in the window to their occurrence count
            */
            char characterAtRightPointer = searchString.charAt(right);
            addCharacterToHashtableMapping(windowCharacterMapping, characterAtRightPointer);

            /*
                Is this character part of the requirement?
            */
            boolean rightCharIsARequirement = requiredCharacters.containsKey(characterAtRightPointer);
            if (rightCharIsARequirement) {
                /*
                    Does the current window frequency match the required frequency?
                */
                boolean requirementForCharacterMet = requiredCharacters.get(characterAtRightPointer).intValue() ==
                        windowCharacterMapping.get(characterAtRightPointer).intValue();
                if (requirementForCharacterMet) {
                    /*
                          If so then we have one more frequency requirement that matches...remember when:
                          'totalCharFrequenciesToMatch' == 'charFrequenciesInWindowThatMatch' then we know that
                          we have a satisfying window
                    */
                    charFrequenciesInWindowThatMatch++;
                }
            }

            /*
                  Does this window satisfy? Ok...if it does try contracting the left pointer inward until
                  we go over the right pointer.
            */
            while (charFrequenciesInWindowThatMatch == totalCharFrequenciesToMatch && left <= right) {

                /*
                    Put these things in plain English so you don't get confused
                */
                char characterAtLeftPointer = searchString.charAt(left);
                int windowSize = right - left + 1;

                /*
                    Have we beat the best satisfiable window seen so far? Ok...if so then update
                    the tracking variables
                */
                if (windowSize < minWindowLengthSeenSoFar) {
                    minWindowLengthSeenSoFar = windowSize;
                    minWindow = searchString.substring(left, right + 1);
                }

                /*
                    This character will get contracted out. It won't be in the window anymore once
                    left moves forward.
                */
                windowCharacterMapping.put(characterAtLeftPointer, windowCharacterMapping.get(characterAtLeftPointer) - 1);

                /*
                    Was this character part of the requirement? If so then its frequency changing matters to us.
                */
                boolean leftCharIsARequirement = requiredCharacters.containsKey(characterAtLeftPointer);
                if (leftCharIsARequirement) {
                    /*
                        Does the character frequence count not fall below the threshold of satisfying?
                    */
                    boolean characterFailsRequirement = windowCharacterMapping.get(characterAtLeftPointer).intValue() <
                            requiredCharacters.get(characterAtLeftPointer).intValue();

                    if (characterFailsRequirement) {
                        /*
                            If so then we have one less character frequency mapping in the window that matches
                        */
                        charFrequenciesInWindowThatMatch--;
                    }
                }

                /*
                    Move the left point forward. We will keep going until the window no longer satisfies.
                */
                left++;
            }

            /*
                We have moved left as far as it could go. It either led to a window that no longer
                satisfied or left passed the right pointer. Either way...advance the right pointer.
            */
            right++;
        }

        return minWindow;
    }

    private static Map<Character, Integer> buildMappingOfCharactersToOccurrences(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int occurrencesOfCharacter = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), occurrencesOfCharacter + 1);
        }

        return map;
    }

    private static void addCharacterToHashtableMapping(Map<Character, Integer> map, Character c) {
        int occurrences = map.getOrDefault(c, 0);
        map.put(c, occurrences + 1);
    }
}
