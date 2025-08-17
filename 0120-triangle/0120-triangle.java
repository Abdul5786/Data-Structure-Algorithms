class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // Get the size of the triangle (number of rows)
        int n = triangle.size();
        // Create a DP array to store minimum path sums for the current row
        // Size is n because the last row has n elements
        int[] dp = new int[n];
        
        // Initialize the DP array with the last row of the triangle
        // Since we start from the bottom, the last row's values are the base case
        // dp[i] represents the minimum path sum starting from index i in the last row
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }
        
        // Iterate from the second-to-last row to the top (bottom-up approach)
        // For each row i, compute the minimum path sum for each position j
        for (int i = n - 2; i >= 0; i--) {
            // For each element in row i (row i has i+1 elements)
            for (int j = 0; j <= i; j++) {
                // Update dp[j] to be the current element's value plus the minimum of
                // the two possible paths below it: dp[j] (same column) or dp[j+1] (next column)
                // This ensures dp[j] stores the minimum path sum from position (i, j) to the bottom
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        
        // After the loop, dp[0] contains the minimum path sum from the top (0, 0) to the bottom
        // Because we processed all rows bottom-up, dp[0] is the final answer
        return dp[0];
    }
}