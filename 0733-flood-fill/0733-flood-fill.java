class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int cols = image[0].length;
        int currentColor = image[sr][sc];
        
        // Avoid infinite loop if starting pixel is already the target color
        if (currentColor != color) {
            dfs(sr, sc, color, currentColor, image, rows, cols);
        }
        
        return image;
    }

    public void dfs(int row, int col, int newColor, int currentColor, int[][] image, int rows, int cols) {
        // Boundary and visited checks
        if (row < 0 || row >= rows || col < 0 || col >= cols || image[row][col] != currentColor) {
            return;
        }

        image[row][col] = newColor;

        // Neighbours: up, right, down, left
        int[][] adjList = {{row - 1, col}, {row, col + 1}, {row + 1, col}, {row, col - 1}};

        for (int[] nbr : adjList) {
            dfs(nbr[0], nbr[1], newColor, currentColor, image, rows, cols);
        }
    }
}
