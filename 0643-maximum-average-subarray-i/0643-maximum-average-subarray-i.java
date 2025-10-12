class Solution {
    public double findMaxAverage(int[] nums, int k) 
    {
       int sum=0;
       int left=0;
       double max =Integer.MIN_VALUE;
       int count=0;
       

       for(int right=0;right<nums.length;right++)
       {

          sum +=nums[right];
          count++;
          if(count==k)
          {
             max = Math.max(sum,max);
             count--;
             sum -=nums[left];
             left++;
          }

       }

       return max/k;
    }
}