package com.leetcode.dfs;

/**
 * https://leetcode.com/problems/flood-fill/submissions/
 *
 * DFS. The boundary conditions are already given to be within the limits of the 2D array.
 *
 * Say color is the color of the starting pixel. Let's floodfill the starting pixel: we change the color of that pixel
 * to the new color, then check the 4 neighboring pixels to make sure they are valid pixels of the same color, and of
 * the valid ones, we floodfill those, and so on.
 *
 * We can use a function dfs to perform a floodfill on a target pixel.
 *
 * Time  : O(N), where N is the number of pixels in the image. Worst case, we might process every pixel.
 * Space : O(N), the size of the implicit call stack when calling dfs.
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Set the base condition
        int color = image[sr][sc];
        if(color != newColor) { // Base condition, dfs when the color is - '1'. And not same as newColor - '2'
            dfs(image, sr, sc, color, newColor);
        }
        return image; // return the modified image with the new color
    }

    private void dfs(int[][] image, int row, int col, int color, int newColor) {
        if(image[row][col] == color) { // Again set the base and then recurse
            image[row][col] = newColor;

            // Explore other possibilities, but consider boundaries
            if(row - 1 >= 0)
                dfs(image, row - 1, col, color, newColor);
            if(col - 1 >= 0)
                dfs(image, row, col - 1, color, newColor);
            if(row + 1 < image.length)
                dfs(image, row + 1, col, color, newColor);
            if(col + 1 < image[0].length)
                dfs(image, row, col + 1, color, newColor);
        }
    }

    public static void main(String[] args) {
        FloodFill obj = new FloodFill();
        //int[][] image = obj.floodFill(new int[][]{{1,1,1},{1,1,0},{1,0,1}}, 1, 1, 2);
        int[][] image = obj.floodFill(new int[][]{{0,0,0},{1,0,0}}, 1, 0, 2);
        System.out.print("[");
        for(int nums[] : image) {
            System.out.println();
            System.out.print("    [ ");
            for(int num : nums) {
                System.out.print(num +" ");
            }
            System.out.print("]");
        }
        System.out.println();
        System.out.print("]");
    }
}
