class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;

        // Find the first positive number using binary search
        int firstPositive = findFirstPositive(nums);

        // Find the last negative number using binary search
        int lastNegative = findLastNegative(nums);

        // Count of positive numbers
        int posCount = n - firstPositive;

        // Count of negative numbers
        int negCount = lastNegative + 1;

        // Return the maximum count
        return Math.max(posCount, negCount);
    }

    private int findFirstPositive(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > 0) {
                high = mid - 1; // Narrow the search to the left
            } else {
                low = mid + 1; // Move to the right
            }
        }
        return low; // Index of the first positive number
    }

    private int findLastNegative(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < 0) {
                low = mid + 1; // Move to the right
            } else {
                high = mid - 1; // Narrow the search to the left
            }
        }
        return high; // Index of the last negative number
    }
}