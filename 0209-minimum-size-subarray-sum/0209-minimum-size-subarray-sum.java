class Solution {
    public int minSubArrayLen(int target, int[] nums) 
    {
        int start=0, sum=0 , minLen=Integer.MAX_VALUE;

         for(int end=0;end<nums.length;end++)
         {
            sum+=nums[end];

            while(sum>=target)
            {
                minLen= Math.min(minLen,end-start+1);
                sum-=nums[start++];
            }
         }

         return minLen == Integer.MAX_VALUE ? 0 : minLen; 
    }
}