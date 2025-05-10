class Solution {
    public int threeSumClosest(int[] nums, int target) 
    {
        // first we will sort the arrays to handle duplicacy of elements
        // If sum < target, move left to increase the sum.
        //If sum > target, move right to decrease the sum.

        Arrays.sort(nums);

        int closetSum=Integer.MAX_VALUE;
       for(int i=0;i<nums.length-2;i++)
       {
          int left=i+1; int right=nums.length-1;

          while(left<right)
          {
             int currentSum= nums[i]+nums[left]+nums[right];

              // check closet sum and update the closet sum for every iteration 

              if(Math.abs(currentSum-target)<Math.abs(closetSum-target))
              {
                 closetSum=currentSum;
              }

              if(currentSum<target)
              {
                left++ ;// increase the number
              }

              else if(currentSum>target)
              {
                right--;
              }

              else 
              {
                return target;
              }
          }

       }

       return closetSum;
    }
}