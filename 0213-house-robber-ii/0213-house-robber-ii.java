class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        if (n == 1) return nums[0];
        if(n==2) return  Math.max(nums[0],nums[1]);

        int res1 = rob(nums,0,n-2); // starting from  1st  house 

        int res2 = rob(nums,1,n-1); // starting from 2nd house

        return Math.max(res1,res2);      
    }
    private int rob(int[] nums, int start, int end) {
        int prev = 0, curr = 0;
        for (int i = start; i <= end; i++) {
            int temp = curr;
            curr = Math.max(curr, prev + nums[i]);
            prev = temp;
        }
        return curr;
    }
}