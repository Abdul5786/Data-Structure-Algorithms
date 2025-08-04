class Solution {
    public int minSubArrayLen(int target, int[] nums) 
    {
       
       int left=0;
       int sum=0;
       int minLen=Integer.MAX_VALUE;

       for(int right=0;right<nums.length;right++)
       {
          
          sum +=nums[right];
          while(sum>=target)
          {
           
           minLen = Math.min(right-left+1,minLen);
           sum -=nums[left];
           left ++; // shrinked the window size

          }
       }

         return (minLen == Integer.MAX_VALUE) ? 0 : minLen;

    }
}
    //     int minCount=Integer.MAX_VALUE;
    //     for(int i=0;i<nums.length;i++)
    //     {
    //         int count=0;
    //         int sum=0;

    //         for(int j=i;j<nums.length;j++)
    //         {
            
    //             sum +=nums[j];
    //             count++;
    //             if(sum>=target)
    //             {
    //                 minCount =Math.min(count,minCount);
    //             }

    //         }
    //     }
         
    //      return (minCount == Integer.MAX_VALUE) ? 0 : minCount;
    // }
