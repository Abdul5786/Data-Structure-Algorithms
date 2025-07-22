class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length][amount+1];
        return helper(coins, 0, amount, dp);
    }
    private int helper(int[] coins, int idx, int amount, Integer[][] dp) {
        if (amount == 0) return 1;
        if (amount < 0 || idx == coins.length) return 0;
        if (dp[idx][amount] != null) return dp[idx][amount];
        int take = helper(coins, idx, amount - coins[idx], dp);
        int skip = helper(coins, idx + 1, amount, dp);
        return dp[idx][amount] = take + skip;
    }
}