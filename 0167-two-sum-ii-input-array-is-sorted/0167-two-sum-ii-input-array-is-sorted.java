class Solution {
    public int[] twoSum(int[] nums, int target) 
    {
        int start = 0;
        int end = nums.length - 1;
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                ans[0] = start+1;
                ans[1] = end+1;
                return ans;
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return new int[]{};
    }
}