class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(prices, 0, 0, dp, fee);
    }

    public int helper(int[] prices, int day, int hold, int[][] dp, int fee) {
        if (day == prices.length) return 0;

        if (dp[day][hold] != -1) return dp[day][hold];

        int ans = 0;
        if (hold == 0) { // not holding stock
            int buy = -prices[day] + helper(prices, day + 1, 1, dp, fee);
            int notBuy = helper(prices, day + 1, 0, dp, fee);
            ans = Math.max(buy, notBuy);
        } else { // holding stock
            int sell = prices[day] - fee + helper(prices, day + 1, 0, dp, fee); // fee yaha minus
            int notSell = helper(prices, day + 1, 1, dp, fee);
            ans = Math.max(sell, notSell);
        }

        return dp[day][hold] = ans;
    }
}
