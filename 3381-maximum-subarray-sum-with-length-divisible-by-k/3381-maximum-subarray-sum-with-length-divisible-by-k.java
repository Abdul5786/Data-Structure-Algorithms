class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] pre = new long[n + 1];
        
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }

        long res = Long.MIN_VALUE;

        for (int start = 0; start < k; start++) {
            long currSum = 0;

            for (int i = start; i + k - 1 < n; i += k) {
                int r = i + k - 1; // full block
                long blockSum = pre[r + 1] - pre[i];
                currSum += blockSum;
                res = Math.max(currSum, res);
                if (currSum < 0)
                    currSum = 0;
            }
        }

        return res;

    }
}