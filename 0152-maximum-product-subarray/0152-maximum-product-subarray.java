class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = currentMax;

            currentMax = Math.max(Math.max(nums[i], currentMax * nums[i]), currentMin * nums[i]);
            currentMin = Math.min(Math.min(nums[i], temp * nums[i]), currentMin * nums[i]);

            maxProduct = Math.max(maxProduct, currentMax);
        }

        return maxProduct;
    }
}
