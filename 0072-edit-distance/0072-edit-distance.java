import java.util.Arrays;

class Solution {

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(word1, word2, 0, 0, dp);
    }

    public int helper(String word1, String word2, int i, int j, int[][] dp) {
        if (i == word1.length()) return word2.length() - j; // Insert all remaining characters of word2
        if (j == word2.length()) return word1.length() - i; // Delete all remaining characters of word1

        if (dp[i][j] != -1) return dp[i][j];

        if (word1.charAt(i) == word2.charAt(j)) {
            dp[i][j] = helper(word1, word2, i + 1, j + 1, dp); // Characters match, move both pointers
        } else {
            int insert = 1 + helper(word1, word2, i, j + 1, dp);
            int delete = 1 + helper(word1, word2, i + 1, j, dp);
            int replace = 1 + helper(word1, word2, i + 1, j + 1, dp);
            dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }

        return dp[i][j];
    }
}
