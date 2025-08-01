class Solution {
    public int[] runningSum(int[] nums) 
    {
       
       int prefix=0;

       for(int i=0;i<nums.length;i++)
       {
           
           prefix +=nums[i];
           nums[i] =prefix;
       }
        
        return nums;
    }
}