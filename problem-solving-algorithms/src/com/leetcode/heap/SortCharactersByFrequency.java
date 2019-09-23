package com.leetcode.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *  https://leetcode.com/problems/sort-characters-by-frequency/
 *
 *  Similar to https://leetcode.com/problems/top-k-frequent-words/, instead of String, here its Character
 *
 *  Time  : N Log N, we offer and poll (log N) operation for N characters in the given string
 *  Space : O(N), we store N characters and its count in the hashmap
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        // Put each character and it's corresponding count into the hashmap
        for(Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Create a max heap that will have the least frequent characters by count on the bottom, most frequent by count on top of the heap
        PriorityQueue<Character> maxHeap = new PriorityQueue((c1, c2) -> map.get(c2) - map.get(c1));
        for(Character c : map.keySet()) {
            maxHeap.offer(c);
        }

        // Build the string back, so the maxHeap will first have the most frequent character, then the rest
        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            int count = map.get(c);
            while(count-- > 0) { // Iterate the number of times the character is present in the given original input string
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SortCharactersByFrequency obj =  new SortCharactersByFrequency();
        System.out.println(obj.frequencySort("tree"));
    }
}
