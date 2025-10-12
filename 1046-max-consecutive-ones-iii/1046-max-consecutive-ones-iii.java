class Solution {
    public int longestOnes(int[] nums, int k) 
    {
        int zeroCount=0;
        int left=0;
        int max =Integer.MIN_VALUE;

        for(int right=0;right<nums.length;right++)
        {
             
             if(nums[right]==0)
             {
                zeroCount++;
             }

             while(zeroCount>k)
             {
                 
                 if(nums[left]==0)
                 {
                     zeroCount--;
                 }

                 left++;
             }

           max = Math.max(right-left+1,max);
        }

        return max;
        
    }
}