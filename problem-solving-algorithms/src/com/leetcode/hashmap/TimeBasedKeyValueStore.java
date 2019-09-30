package com.leetcode.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *  https://leetcode.com/problems/time-based-key-value-store
 *
 *  Can be solved in two approaches.
 *      Approach 1 - Using HashMap of Lists can be seen below
 *      Approach 2 - Using TreeMap can be seen under the TreeMap package
 *
 *  Time  : O(1) for each set operation, and O(logN) for each get operation, where N is the number of entries in the TimeMap.
 *  Space : O(N)
 */
public class TimeBasedKeyValueStore {
    /**
     * Approach 1, using HashMap of list
     */
    // Pair class that will hold the value of the hashmap key with the timestamp
    class Data {
        int time;
        String value;

        public Data(int time, String value) {
            this.time = time;
            this.value = value;
        }
    }

    Map<String, List<Data>> map;
    /** Initialize your data structure here. */
    public TimeBasedKeyValueStore() {
        map = new HashMap<>(); // Initialize the map
    }

    public void set(String key, String value, int timestamp) {
        // Check if the map has the value for the corresponding key
        // If not present, initialize the array list (Data object) of the HashMap
        if(!map.containsKey(key))
            map.put(key, new ArrayList<Data>());

        // Insert the new value with the new timestamp using pass by constructor
        map.get(key).add(new Data(timestamp, value));
    }

    public String get(String key, int timestamp) {

        // If there is no value corresponding to the key in the hashmap, meaning if the list is null, we simply return an empty string
        List<Data> list = map.get(key);
        if(list == null)
            return "";

        // Else, do the binary search to find and return the next greatest or equal value based on the timestamp
        return binarySearch(map.get(key), timestamp);
    }

    private String binarySearch(List<Data> list, int timestamp) {
        int lo = 0, hi = list.size() - 1;
        while(lo < hi) {
            int mid = (lo + hi) / 2;
            if(list.get(mid).time == timestamp)
                return list.get(mid).value;
            if(list.get(mid).time < timestamp) {
                // To handle the case similar to - obj.get("love", 15) when "love", 10 and "love", 20 are in the list,
                // we have to return "love", 10 value. i.e "high" for that test case
                if(list.get(mid + 1).time > timestamp)
                    return list.get(mid).value;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        // When the time stored in the list is smaller than the given timestamp, return the value of it.
        return list.get(lo).time <= timestamp ? list.get(lo).value : "";
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
