package com.leetcode.backtracking;

import java.util.*;

/**
 * Time  : O(len(wordDict)^len(s)) = O(len(wordDict) ^ len(s / minWordLenInDict)), because there are len(wordDict)
 *         possibilities for each cut
 *
 *         O(2^n) in the worse case scenario where all combinations of the string are correct
 *         For example, s = aaa, wordDict = [a, aa, aaa]).
 *
 *         Backtracking is one type of DFS. DFS may also be used in graph, matrix, linked list, tree, etc
 *         where we usually do not say backtracking. Hope it helps.
 *
 * Space : Same as time, for the same reason - every partition is stored in memory.
 *
 */
public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        /*
            Call the helper function. Passing the HashMap to memoize the result with
            current s as the key and the result list as the value
        */
        return wordBreakHelper(s, wordDict, new HashMap<String, List<String>>());
    }

    private List<String> wordBreakHelper(String s, List<String> wordDict, Map<String, List<String>> memo) {
        // Check if the current s is already memoized in the HashMap, if it is, return that
        if(memo.containsKey(s)) {
            return memo.get(s);
        }
        // If the memoized map doesn't contain the current s as the key, then try to compute if s can be broken
        else {
            /*
                Declare the result list that will be used to compute if the given s can be broken based
                on the given words in the dictionary
            */
            List<String> res = new ArrayList<>();

            // Iterate through the words in the given wordDict
            for(String word : wordDict) {
                // Check if the current s starts with the current word in the dictionary
                if(s.startsWith(word)) {
                    /*
                        If the current s does start with the, break the current word up to the current word
                        in the iteration, store the other part of the current s in a string "next"
                    */
                    String next = s.substring(word.length());
                    /*
                        Check if the next's length is zero. If it is, then it means that we don't have anymore
                        string to break down to, therefore we will simply add the current word to the result

                        Else, we can segment s even more to check if sentences can be formed with other words in
                        the given dictionary
                    */
                    if(next.length() == 0) {
                        res.add(word);
                    } else {
                        // Pass the next we segmented in the previous step to see if more words can be added to the sentence

                        /*
                            Once we got all the words that can be formed for the given s, then we add the current word
                            with the previous sub word we computed by recursion

                            For example: s = "catsanddog", wordDict = ["cat", "cats", "and", "sand", "dog"],

                            Recursion tree:
                                1. s = "catsanddog", word matched with in the wordDict = "cat",  next = "sanddog"
                                2. s = "sanddog",    word matched with in the wordDict = "sand", next = "dog"
                                3. s = "dog",        word matched with in the wordDict = "dog",  next = ""

                            After the recursion ends with next.length == 0, therefore "dog" getting added to the res list,
                                3. returns the res list with the word - "dog"
                                2. s = "sanddog", word = "sand", returned sublist = "dog", appends itself (word) - "sand dog"
                                1. s = "catsanddog", word = "cat", returned sublist = "sand dog", appends itself (word) - "cat sand dog"

                            When the recursion comes back to s = "catsanddog", it starts the next level by moving on the next
                            starts with word "cats" in the wordDict
                                1. s = "catsanddog", word matched with in the wordDict = "cats", next = "anddog"
                                2. s = "anddog",     word matched with in the wordDict = "and",  next = "dog"
                                3. s = "dog",        word matched with in the wordDict = "dog",  next = ""

                            After the recursion ends with next.length == 0, therefore "dog" getting added to the res list,
                                3. returns the res list with the word - "dog"
                                2. s = "anddog", word = "and", returned sublist = "dog", appends itself (word) - "and dog"
                                1. s = "catsanddog", word = "cats", returned sublist = "and dog", appends itself (word) - "cats and dog"

                            Each time the iteration through the wordDict ends, we memoize the current s and its corresponding
                            result list, so that next time when the same s is requested for, we can give the value from the
                            the HashMap we have stored with the key = current s, value = current res list
                        */
                        List<String> subList = wordBreakHelper(next, wordDict, memo);
                        for(String sub : subList) {
                            // Append the current word to sub word returned by the previous recursion stack
                            res.add(word +" "+ sub);
                        }
                    }
                }
            }
            // Memoize the current s with its corresponding res list to fetch this next time when the same key is requested for
            memo.put(s, res);
            return res;
        }
    }

    public static void main(String[] args) {
        WordBreakII obj = new WordBreakII();
        List<String> sentences = obj.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"));

        // Print output
        System.out.print("[");
        for(String sentence : sentences) {
            System.out.println();
            System.out.print("     ");
            System.out.print('"');
            System.out.print(sentence);
            System.out.print('"');
        }
        System.out.println();
        System.out.println("]");
    }
}
