class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums); // Pehle sort kar lo
        int i = 0;
        // Sabse pehle negative numbers ko flip karo
        while (i < nums.length && nums[i] < 0 && k > 0) {
            nums[i] = -nums[i];
            i++;
            k--;
        }
        // Agar flips bach gaye, toh sabse chhote number ko flip karo agar k odd hai
        Arrays.sort(nums); // Dobara sort taaki smallest mil jaaye
        if (k % 2 == 1) nums[0] = -nums[0];
        // Ab sab add kar do
        int sum = 0;
        for (int num : nums) sum += num;
        return sum;
    }
}