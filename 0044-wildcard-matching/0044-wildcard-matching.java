import java.util.*;

class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(s, p, 0, 0, dp) == 1;
    }

    public int helper(String s, String p, int i, int j, int[][] dp) {
        // ✅ if both string and pattern end
        if (i == s.length() && j == p.length()) return 1;

        // ❌ pattern khatam but string bachi
        if (j == p.length()) return 0;

        // ✅ memoization check
        if (dp[i][j] != -1) return dp[i][j];

        // ✅ string end but pattern bacha → saare * hone chahiye
        if (i == s.length()) {
            for (int k = j; k < p.length(); k++) {
                if (p.charAt(k) != '*') {
                    return dp[i][j] = 0;
                }
            }
            return dp[i][j] = 1;
        }

        // ✅ match case → same char ya '?'
        if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
            dp[i][j] = helper(s, p, i + 1, j + 1, dp);
            return dp[i][j];
        }

        // ✅ star case → 2 options (consume ek char ya skip star)
        if (p.charAt(j) == '*') {
            if (helper(s, p, i + 1, j, dp) == 1 || helper(s, p, i, j + 1, dp) == 1) {
                return dp[i][j] = 1;
            }
        }

        // ❌ default case → no match
        return dp[i][j] = 0;
    }
}
