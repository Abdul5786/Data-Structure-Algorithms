class Solution {
    public int maximumProduct(int[] nums) {
    // Step 1: Sort the array
    Arrays.sort(nums);

    // Step 2: Calculate the two possible products
    // Case 1: Product of the three largest numbers
    int case1 = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];

    // Case 2: Product of the two smallest numbers (could be negative) and the largest number
    int case2 = nums[0] * nums[1] * nums[nums.length - 1];

    // Step 3: Return the maximum of the two cases
    return Math.max(case1, case2);
}

}