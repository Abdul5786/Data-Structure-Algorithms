class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    // Check all four directions
                    perimeter += 4;
                    if (i > 0 && grid[i - 1][j] == 1) perimeter--; // upper cell
                    if (i < grid.length - 1 && grid[i + 1][j] == 1)             perimeter--; // lower cell
                    if (j > 0 && grid[i][j - 1] == 1) perimeter--; // left cell
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) perimeter--; // right cell
                }
            }
        }
        return perimeter;
    }
}