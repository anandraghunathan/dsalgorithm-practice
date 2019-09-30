package com.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 *  https://leetcode.com/problems/is-graph-bipartite
 *
 *  Our goal is trying to use two colors to color the graph and see if there are any adjacent nodes having the same color.
 *      Initialize a color[] array for each node. Here are three states for colors[] array:
 *          0: Haven't been colored yet.
 *          1: Blue.
 *          -1: Red.
 *  For each node,
 *      If it hasn't been colored, use a color to color it. Then use the other color to color all its adjacent nodes (DFS).
 *      If it has been colored, check if the current color is the same as the color that is going to be used to color it.
 *
 *  Time  : O(V + E). Node = Vertex. Edges = Each element inside the 2D array
 *  Space : O(n)
 */
public class IsGraphBipartite {
    // {{1,3},{0,2},{1,3},{0,2}}
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];

        for (int i = 0; i < len; i++) {
            if (colors[i] != 0)
                continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            colors[i] = 1;   // Blue: 1; Red: -1.

            while (!queue.isEmpty()) {
                int currNode = queue.poll();
                for (int next : graph[currNode]) {
                    if (colors[next] == 0) {          // If this node hasn't been colored;
                        colors[next] = -colors[currNode];  // Color it with a different color;
                        queue.offer(next);
                    } else if (colors[next] != -colors[currNode]) {   // If it is colored and its color is different, return false;
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsGraphBipartite obj = new IsGraphBipartite();
        System.out.println(obj.isBipartite(new int[][]{{1,3},{0,2},{1,3},{0,2}}));
        //System.out.println(obj.isBipartite(new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}}));
    }
}
