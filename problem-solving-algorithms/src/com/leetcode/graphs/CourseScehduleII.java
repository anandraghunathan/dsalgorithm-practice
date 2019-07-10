package com.leetcode.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/course-schedule-ii
 */
public class CourseScehduleII {
    public static int[] findCourseOrder(int numCourses, int[][] prerequisites) {
        // A node (a vertex) has more than one edge, Therefore, to represent more than one edge from a vertex, we need a two dimensional array
        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];

        // Result array that will be returned with the correct ordering of finished courses
        int[] res = new int[numCourses];

        /** Step 1 - Iterate through the length of the pre-requisites 2D array and find the indegree for each vertex of the graph */
        for(int i = 0; i < prerequisites.length; i++) {

            // Current course to take
            int ready = prerequisites[i][0];

            // Pre requisite course that should have been completed prior to taking the ready course computed above
            int pre = prerequisites[i][1];

            /* If 0, it means there is a pre-requisite/dependency between one another, so increment the indegree of the
                current course index. Then, set it's value to 1 */
            if(matrix[pre][ready] == 0) {

                /* For example for input {1, 0}, indegree[1] will become 1, since the course 1 can be completed only after course 0 */
                indegree[ready]++;
            }

            /* For example for input {1, 0}, make the matrix[0][1] index value as 1, since the course 1 can be completed only after course 0 */
            matrix[pre][ready] = 1;
        }

        /** Step 2 - Start with vertex with indegree 0 and add the corresponding index to the queue */
        // Courses count to validate if all courses can finally be finished. Should be equal to the numCourses provided in the input
        int count = 0;

        // Queue used to compute the number of courses
        Queue<Integer> queue = new LinkedList<>();

        // Iterate through the indegree array length
        for(int i = 0; i < indegree.length; i++) {
            /* If the indegree is 0, it means that course can be completed, if its 1, the other course has to be
                completed before this current one. */
            if(indegree[i] == 0)
                queue.offer(i);
        }

        /** Step 3a - Remove the vertex 'v' (course) from the queue with indegree 0 */

        // Iterate through the queue, to figure out the number of courses that can be completed
        while(!queue.isEmpty()) {

            // Remove the vertex
            int course = queue.poll();


            // assign the current course to the res array's count index (increment the count cause we found a course with indegree 0)
            res[count++] = course;

            /** Step 3b - Remove all the edges 'e' (pre-requisites) coming out of the vertex that's indegree is not 0.
             *  Basically decrement the indegrees of all adjacent vertices if not 0, if zero, add the index to the queue
             */

            // Iterate through number of times based on input numCourses
            for(int i = 0; i < numCourses; i++) {
                /* If the value of the index (course) of the matrix is not zero, which means the indegree has to be
                 broken as per topological sorting approach */
                if (matrix[course][i] != 0) {
                    if (--indegree[i] == 0)
                        /* Push the index back to the queue to repeat the process of removing all the vertices and the
                            edges coming out of it (To repeat this process till all vertices have indegree 0) */
                        queue.offer(i);
                }
            }
        }

        /* If the input array has a loop, indegree for all courses will be 1, so removing the vertices and its edges
        will never happen. We handle this and return an empty array using the below logic */
        for (int i : indegree) {
            if (i != 0) return new int[0];
        }

        // Finally, return the res array
        return res;
    }

    public static void main(String[] args) {

        /** For example: for input {0, 1} - To complete the course 0, you should first complete course 1 */
        for (int order : findCourseOrder(2, new int[][]{{0, 1}, {1, 0}})) {
            System.out.print(order + ", ");
        }
    }
}
