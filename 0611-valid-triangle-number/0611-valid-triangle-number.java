import java.util.Arrays;

class Solution {
    public int triangleNumber(int[] nums) {
        // Step 1: Sort the array
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;

        // Step 2: Iterate through the array to fix the largest side
        for (int k = n - 1; k >= 2; k--) {
            int i = 0;       // Left pointer
            int j = k - 1;   // Right pointer

            // Step 3: Use two-pointer approach to find valid triangles
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    // All pairs between i and j are valid
                    count += (j - i);
                    j--; // Move the right pointer inward
                } else {
                    i++; // Move the left pointer outward
                }
            }
        }

        return count; // Return the total number of valid triangles
    }
}