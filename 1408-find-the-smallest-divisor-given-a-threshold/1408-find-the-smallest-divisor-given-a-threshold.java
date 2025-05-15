class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = getMax(nums);
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(nums, mid, threshold)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private int getMax(int[] nums) {
        int max = nums[0];
        for (int n : nums) {
            max = Math.max(max, n);
        }
        return max;
    }

    private boolean isPossible(int[] nums, int divisor, int threshold) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += Math.ceil((double)num/divisor);
        }
        return totalSum <= threshold;
    }
}
