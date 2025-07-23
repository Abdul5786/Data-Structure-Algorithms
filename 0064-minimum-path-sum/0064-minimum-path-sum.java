class Solution {
    public int minPathSum(int[][] grid) 
    {
        int m= grid.length; // rows
        int n= grid[0].length; // cols

        int dp[][] =new int[m][n];

        dp[0][0] = grid[0][0];

        // filling first rows

        for(int j=1;j<n;j++)
        {
            dp[0][j] = dp[0][j-1]+grid[0][j];
        }

        // filling cols
        for(int i=1;i<m;i++)
        {
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }

        // filling rest of the cells

        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                dp[i][j] = grid[i][j]+ Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[m-1][n-1];
    }
}