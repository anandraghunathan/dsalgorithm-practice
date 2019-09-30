package com.leetcode.treemap;

import java.util.*;

/**
 *  https://leetcode.com/problems/time-based-key-value-store
 *
 *  Can be solved in two approaches.
 *      Approach 1 - Using Hashmap of Lists can be seen under the hashmap package
 *      Approach 2 - Using TreeMap can be seen below
 *
 *  Time  : O(1) for each set operation, and O(logN) for each get operation, where N is the number of entries in the TimeMap.
 *  Space : O(N)
 */
public class TimeBasedKeyValueStore {
    /**
     * Approach 2 - TreeMap
     */
    Map<String, TreeMap<Integer, String>> map;

    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        // Check if the map has the value for the corresponding key
        // If not present, initialize the array list (Data object) of the HashMap
        if(!map.containsKey(key))
            map.put(key, new TreeMap<Integer, String>());

        // Insert the new value with the new timestamp using pass by constructor
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {

        // If there is no value corresponding to the key in the hashmap, meaning if the treemap is null, we simply return an empty string
        TreeMap<Integer, String> treeMap = map.get(key);
        if(treeMap == null)
            return "";

        // Else, we return the string value corresponding to the greatest key that's less than or equal to the given key
        // as the parameter. In other words, the next latest or equal timestamp value that's available
        Integer floor = treeMap.floorKey(timestamp);
        if(floor == null)
            return "";
        else
            return treeMap.get(floor);
    }

    public static void main(String[] args) {
        TimeBasedKeyValueStore obj = new TimeBasedKeyValueStore();
        System.out.println("Set - love, high, 10 = null");
        System.out.println("Set - love, high, 20 = null");
        obj.set("love", "high", 10);
        obj.set("love", "low", 20);
        System.out.print("Get - love, 5 = ");
        System.out.print(obj.get("love", 5).equals("") ? "null" : "");
        System.out.println();
        System.out.println("Get - love, 10 = " +obj.get("love", 10));
        System.out.println("Get - love, 15 = " +obj.get("love", 15));
        System.out.println("Get - love, 20 = " +obj.get("love", 20));
        System.out.println("Get - love, 25 = " +obj.get("love", 25));
    }
}
