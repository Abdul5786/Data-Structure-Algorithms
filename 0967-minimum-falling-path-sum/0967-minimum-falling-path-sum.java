class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length; // Matrix ka size n x n hai. Example: [[2,1,3]] n=3

        int[][] dp = new int[n][n]; // DP array banaya taaki repeat calculation na ho

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE); // Sabko initially MAX_VALUE diya, taaki pata chale abhi solve nahi hua
        }

        int ans = Integer.MAX_VALUE; // Final answer ko ek bade value se start kiya

        // First row ke har column se path try karenge
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, helper(0, j, matrix, dp)); // Har starting point ka min path sum nikal ke, overall min le liya
            // Example: matrix = [[2,1,3],[6,5,4],[7,8,9]] toh j = 0,1,2 se start karenge
        }
        return ans; // Minimum path sum return kar diya
    }

    private int helper(int i, int j, int[][] matrix, int[][] dp) {
        int n = matrix.length;

        if (j < 0 || j >= n) return Integer.MAX_VALUE; // Agar column out of bounds ho gaya toh valid path nahi, isliye MAX_VALUE
        // Example: Agar j=-1 ya j==n, toh path galat hai

        if (i == n - 1) return matrix[i][j]; // Last row pe pahunch gaye toh wahi value return karo
        // Example: matrix[2][1] return hoga agar last row hai

        if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j]; // Agar pehle se answer hai, toh wapas wahi return
        // Example: dp[1][2] already calculated hai toh usey wapas de do

        // 3 direction mein ja sakte hain: left-diagonal, down, right-diagonal
        int left = helper(i + 1, j - 1, matrix, dp); // Left diagonal move
        int down = helper(i + 1, j, matrix, dp); // Seedha niche move
        int right = helper(i + 1, j + 1, matrix, dp); // Right diagonal move

        // Current cell ki value + teenon moves ka minimum
        dp[i][j] = matrix[i][j] + Math.min(down, Math.min(left, right));
        // Example: matrix[1][1] + min(matrix[2][0], matrix[2][1], matrix[2][2])

        return dp[i][j]; // Calculated value return
    }
}