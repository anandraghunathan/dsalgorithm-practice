package com.leetcode.string;

import java.util.*;

/**
 * Created by Anand Raghunathan on 2019-08-28
 */
public class WordLadder {
    /** Regular BFS */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDict = new HashSet<>(wordList);

        // If the word dictionary doesn't contain the endWord, then return 0
        if(!wordDict.contains(endWord))
            return 0;

        // We add the begin word to the queue to start the comparison
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        /*
            We define a len variable to track the transformations we are making, we start from 1 because beginWord is
            counted as one transformation
         */
        for(int len = 1; !queue.isEmpty(); len++) {
            /*
                We iterate from the reverse based on the queue size. So if the queue has 1 word, we start from 1 and
                decrement down till the queue has more than 0
             */
            for(int i = queue.size(); i > 0; i--) {
                String word = queue.poll();

                /*
                    We will check if the current word is actually the endWord, if yes we simply return the current
                    length as we have found the word we are looking for
                 */
                if(word.equals(endWord))
                    return len;

                /*
                    Else we have do transformations
                    Once we get the current word, we then convert that into an character array to perform the transformation
                 */
                for(int j = 0; j < word.length(); j++) {
                    char[] ch = word.toCharArray();
                    /*
                        Perform transformation by iterating through the character array, since the given
                        problem states that all alphabets will be in smaller case, we will replace the current
                        character in the array with each alphabet starting from 'a' to 'z'
                    */
                    for(char c = 'a'; c <= 'z'; c++) {

                        // Replace the character at index j with the current alphabet
                        ch[j] = c;

                        /*
                            Convert the transformed character array to a String to do check if this tranformedStr is part
                            of the wordDict
                         */

                        String transformedStr = String.valueOf(ch);
                        /*
                            We check if the current transformedStr is part of the dict, which means we have to perform
                            at least one more transformation, so we add it to our queue and remove that word from the
                            dictionary as we have already done the comparison for that word
                        */
                        if(wordDict.contains(transformedStr) && !transformedStr.equals(word)) {
                            queue.offer(transformedStr);
                            wordDict.remove(transformedStr);
                        }
                    }
                }
            }
        }
        return 0;
    }
    /** Regular BFS another approach */
//    public int ladderLengthBFS(String beginWord, String endWord, List<String> wordList) {
//        Set<String> dict = new HashSet<>(wordList), vis = new HashSet<>();
//        Queue<String> q = new LinkedList<>();
//        q.offer(beginWord);
//        for (int len = 1; !q.isEmpty(); len++) {
//            for (int i = q.size(); i > 0; i--) {
//                String w = q.poll();
//                if (w.equals(endWord)) return len;
//
//                for (int j = 0; j < w.length(); j++) {
//                    char[] ch = w.toCharArray();
//                    for (char c = 'a'; c <= 'z'; c++) {
//                        if (c == w.charAt(j)) continue;
//                        ch[j] = c;
//                        String nb = String.valueOf(ch);
//                        if (dict.contains(nb) && vis.add(nb)) q.offer(nb);
//                    }
//                }
//            }
//        }
//        return 0;
//    }
//
    /** Two ended BFS - Faster */
//    public int ladderLengthTwoEndBFS(String beginWord, String endWord, List<String> wordList) {
//        Set<String> dictSet = new HashSet<>(wordList), beginSet = new HashSet<>(), endSet = new HashSet<>(), visitedSet = new HashSet<>();
//        beginSet.add(beginWord);
//
//        if (dictSet.contains(endWord))
//            endSet.add(endWord); // all transformed words must be in dictSet (including endWord)
//
//        for (int len = 2; !beginSet.isEmpty(); len++) {
//            Set<String> tempSet = new HashSet<>();
//            for (String word : beginSet) {
//                for (int j = 0; j < word.length(); j++) {
//                    char[] ch = word.toCharArray();
//                    for (char c = 'a'; c <= 'z'; c++) {
//                        if (c == word.charAt(j))
//                            continue; // beginWord and endWord not the same, so bypass itself
//                        ch[j] = c;
//                        String tempWord = String.valueOf(ch);
//                        if (endSet.contains(tempWord))
//                            return len; // meet from two ends
//                        if (dictSet.contains(tempWord) && visitedSet.add(tempWord))
//                            tempSet.add(tempWord); // not meet yet, visitedSet is safe to use
//                    }
//                }
//            }
//            beginSet = (tempSet.size() < endSet.size()) ? tempSet : endSet; // switch to small one to traverse from other end
//            endSet = (beginSet == tempSet) ? endSet : tempSet;
//        }
//        return 0;
//    }

    public static void main(String[] args) {
        WordLadder obj = new WordLadder();
        System.out.println(obj.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","cog")));
    }
}
