class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // Initialize with -1 for memoization
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        // Find LPS length
        int lps = helper(s, 0, n - 1, dp);

        // Minimum insertions = total length - LPS length
        return n - lps;
    }

    // Recursive + Memoized function to find LPS length
    public int helper(String s, int start, int end, int[][] dp) {
        // If invalid range, return 0
        if (start > end) return 0;

        // Single char is always palindrome of length 1
        if (start == end) return 1;

        // If already computed, return from dp
        if (dp[start][end] != -1) return dp[start][end];

        // If both ends match → take both ends into LPS
        if (s.charAt(start) == s.charAt(end)) {
            dp[start][end] = 2 + helper(s, start + 1, end - 1, dp);
        }
        // Else take the max of excluding either end
        else {
            dp[start][end] = Math.max(helper(s, start + 1, end, dp),
                                      helper(s, start, end - 1, dp));
        }

        return dp[start][end];
    }
}
