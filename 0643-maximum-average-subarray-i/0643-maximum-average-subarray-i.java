class Solution {
    public double findMaxAverage(int[] nums, int k) 
    {
        double max=Integer.MIN_VALUE;

        int start=0;
        int  sum =0;
        int count=0;

        for(int end=0;end<nums.length;end++)
        {

            sum +=nums[end];
            count++;

           if(count==k)
           {

               max = Math.max(max,sum);
               count--;
               sum -=nums[start];
               start++;        
           }
        }

        return max/k;
    }
}