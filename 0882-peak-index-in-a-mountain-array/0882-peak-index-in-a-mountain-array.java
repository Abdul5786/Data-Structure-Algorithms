class Solution {
    public int peakIndexInMountainArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                // We are on the increasing slope
                left = mid + 1;
            } else {
                // We are on the decreasing slope (or at the peak)
                right = mid;
            }
        }
        // left == right → peak index
        return left;
    }
}
