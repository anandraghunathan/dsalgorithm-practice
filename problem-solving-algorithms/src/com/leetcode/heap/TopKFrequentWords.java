package com.leetcode.heap;

import java.util.*;

/**
 *  Solved on Sep 20 2019
 *
 *  https://leetcode.com/problems/top-k-frequent-words/
 *
 *  Intuition and Algorithm:
 *      Count the frequency of each word, then add it to heap that stores the best k candidates. Here, "best" is defined
 *      with our custom ordering relation, which puts the worst candidates on top of the heap. At the end, we pop off
 *      the heap up k times and reverse the result so that the best candidates are first in the result list.
 *
 *      1. Add the words to the map with its count
 *      2. Define the PriorityQueue or custom order heap
 *      3. Add the words to the heap that will get ordered lexicographically
 *      4. Push the most frequent words into the result list and reverse the order cause the heap will have the words
 *         in the reverse order
 *
 *  Time  : O(N log K), we offer k words (log K) N times
 *  Space : O(N), hashmap to store N words with its count
 *
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> count = new HashMap<>();
        // 1. Count the frequency of each word and add it to the map with it's count
        for(String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        /*
            Compare the two word counts (from the map we just added to) and add it to the minHeap in the increasing
            order, so the string with the least count will be on top and will be removed first compared to the string
            with most count that will be at the bottom of the min heap

            If the two string have the same count,
                then we compare the words lexicographically (alphabetical order), so the word that starts with an
                earliest letter of the alphabets will stay at the bottom of the heap, whereas, the word that starts
                with the farthest letter of the alphabets will be on top of the heap
         */

        // 2. Define the PriorityQueue or custom order heap
        PriorityQueue<String> heap = new PriorityQueue<>(
                new Comparator<String>() {
                    @Override
                    public int compare(String w1, String w2) {
                        return count.get(w1).equals(count.get(w2))
                                ? w2.compareTo(w1)
                                : count.get(w1) - count.get(w2);
                    }
                }
                                                        );

        // 3. Add the words to the heap that will get ordered lexicographically based on the custom order we defined
        for(String word : count.keySet()) {
            /*
                If there are more than k elements in the heap, poll(remove) the top element that will either be the word
                with the least count compared to other words, or the one that starts the farthest in terms of the
                alphabetical order or both.

                String.compareTo method definition from Java Doc:

                Compares two strings lexicographically. The comparison is based on the Unicode value of each character
                in the strings. The character sequence represented by this String object is compared lexicographically
                to the character sequence represented by the argument string. The result is a negative integer if this
                String object lexicographically precedes the argument string. The result is a positive integer if this
                String object lexicographically follows the argument string. The result is zero if the strings are equal;
                compareTo returns 0 exactly when the equals(Object) method would return true.

                This is the definition of lexicographic ordering.
                   If two strings are different, then either they have different characters at some index that is a
                   valid index for both strings, or their lengths are different, or both. If they have different
                   characters at one or more index positions, let k be the smallest such index; then the string
                   whose character at position k has the smaller value, as determined by using the < operator,
                   lexicographically precedes the other string. In this case, compareTo returns the difference of the
                   two character values at position k in the two string -- that is, the value:
            */
            heap.offer(word);

            if(heap.size() > k)
                heap.poll();
        }
        /*
            4. Push the most frequent words into the result list and reverse the order cause the heap will have the words
                in the reverse order
        */
        List<String> res = new ArrayList<>();
        while(!heap.isEmpty()) {
            res.add(heap.poll());
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        TopKFrequentWords obj = new TopKFrequentWords();
        //List<String> res = obj.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
        List<String> res = obj.topKFrequent(new String[]{"i", "love", "liacode", "i", "liakinf", "liakine"}, 2);
        int resCount = res.size();
        System.out.print("[");
        for(String word : res) {
            System.out.print("\"" + word + "\"");
            System.out.print(resCount-- > 1 ? ", " : "");
        }
        System.out.println("]");
    }
}
