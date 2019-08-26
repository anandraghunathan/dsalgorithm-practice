package com.leetcode.hard;

import java.util.*;

/**
 * Created by Anand Raghunathan on 2019-08-22
 *
 * https://leetcode.com/problems/the-skyline-problem/
 *
 * https://www.youtube.com/watch?v=GSBLe8cKu0s
 *
 * Time  : O(N log N), log N time each for adding, removing and accessing the TreeMap. In PQ, removing takes O(N)
 *
 * Space : O(N), takes linear space
 *
 */
public class SkylineProblem {

    /**
     *
     * Explanation of the approach for easy understanding:
     *
     * Store all the coordinate values in height ArrayList and mark the height of each start/left coordinate as negative.
     * We'll discuss it why soon
     *
     * Then, sort the height array such that it considers following conditions:
     *
     * i. When the two points are not equal then sort them by coordinate values.
     * ii. When two coordinate values are same, then check
     *          a. If both of them are start or left coordinates, consider the largest height.
     *             (That's why left coordinate heights are marked negative).
     *          b. If both of them are end or right coordinates, consider the shortest height.
     *          c. If one of them is end/right and other is start/left then consider the start/left height.
     *
     * Iterate height ArrayList and store height values in the TreeMap (reverse ordered) only if current
     * coordinate is a left/start coordinate. Remove a height value from the map if we encounter a right/end coordinate.
     *
     * Check if the maximum height changes in map after each iteration. If so then add current maxheight and current
     * coordinate to result array.
     *
     * As we remove from priority queue it takes O(n) time. Instead of that, we use a TreeMap to sort values by height
     * and remove values in O(log n) time.
     *
     *  * Time complexity is O(nlogn)
     *  * Space complexity is O(n)
     *
     */
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> heights = new ArrayList<>(); // height list to store all buildings' heights
        for (int[] b: buildings) {
            heights.add(Arrays.asList(b[0], -b[2])); // start of a building, height stored as negative
            heights.add(Arrays.asList(b[1], b[2]));  // end of a building, height stored as positive
        }
        /*
            Since we use negative heights here we could get the correct sorting order.
            This way we use the negative sign to keep track whether it is the beginning or end of the building

            When the two points are not equal then sort them by coordinate values. When two coordinates are same, check
                a. If both of them are start or left coordinates. If so, consider the largest height.
                b. If both of them are end or right coordinates. If so, consider the shortest height.
                c. If one of them is end and other is start then consider the start height.
         */
        Collections.sort(heights, (a, b) -> (a.get(0).intValue() == b.get(0).intValue() ? a.get(1) - b.get(1) : a.get(0) - b.get(0))); // sort the height list

        // using TreeMap to archive TreeMultiSet
        TreeMap<Integer, Integer> heightMap = new TreeMap<>(Collections.reverseOrder());
        heightMap.put(0, 1); //add a sentinel to avoid processing with empty TreeMap
        int prevHeight = 0; // Height of the previous key point

        List<List<Integer>> skyLine = new LinkedList<>();
        for (List<Integer> h: heights) {
            if (h.get(1) < 0) { // h[1] < 0, that means it meets a new building, so add it to map
                Integer cnt = heightMap.get(-h.get(1));
                cnt = ( cnt == null ) ? 1 : cnt + 1;
                heightMap.put(-h.get(1), cnt);
            } else {        // h[1] >=0, that means it has reached the end of the building, so remove it from map
                Integer cnt = heightMap.getOrDefault(h.get(1), 0);
                if (cnt == 1) {
                    heightMap.remove(h.get(1));
                } else {
                    heightMap.put(h.get(1), cnt - 1);
                }
            }
            // the current max height in all encountered buildings
            int currHeight = heightMap.firstKey();

            // if the max height is different from the previous one, that means a critical point is met, add to result list
            if (prevHeight != currHeight) { // find a new skyline strip
                skyLine.add(Arrays.asList(h.get(0), currHeight));
                prevHeight = currHeight;
            }
        }
        return skyLine;
    }

    public static void main(String[] args) {
        SkylineProblem obj = new SkylineProblem();
        List<List<Integer>> res = (obj.getSkyline
                        (new int[][]
                            {
                                {2, 9, 10}, {2, 9, 15}, {2, 12, 12}
                            }
                        )
        );
        System.out.print("[");
        System.out.println("    ");
        for(List<Integer> arr : res) {
            System.out.print("  [");
            int count = 0;
            for(int i : arr) {
                count++;
                System.out.print(" " +i);
                if(count != arr.size())
                    System.out.print(",");
            }
            System.out.print("],");
        }
        System.out.println("");
        System.out.print("]");
    }
}
