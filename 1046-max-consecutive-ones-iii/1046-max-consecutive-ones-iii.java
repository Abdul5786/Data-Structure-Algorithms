class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0, zeroCount = 0, max = 0;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[start] == 0) {
                    zeroCount--;
                }
                start++; // because window is changes we need todecrease zero count
            }

            max = Math.max(max, end - start + 1);

        }

        return max;
    }
}