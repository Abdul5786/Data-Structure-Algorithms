class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        int end=0;
        double max = Integer.MIN_VALUE;
        int count=0;


        for(int start =0;start<nums.length;start++)
        {

              sum +=nums[start];
              count++;

              if(k==count)
              {
                 max =  Math.max(max,sum);
                  count--;
                 sum -=nums[end];
                 end++;
              }           
        }


        return max/k;

      
    }
}
