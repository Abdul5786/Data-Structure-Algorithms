class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) { // corrected loop limit
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return paths(0, 0, dp, obstacleGrid);
    }

    public int paths(int m, int n, int[][] dp, int[][] grid) {
        // Out of bounds or hitting an obstacle
        if (m >= grid.length || n >= grid[0].length || grid[m][n] == 1) return 0;

        // Reached destination
        if (m == grid.length - 1 && n == grid[0].length - 1) return 1;

        if (dp[m][n] != -1) return dp[m][n];

        dp[m][n] = paths(m + 1, n, dp, grid) + paths(m, n + 1, dp, grid);
        return dp[m][n];
    }
}
