class Solution {
    public int splitArray(int[] nums, int k) {

        int max=0,sum=0,result=0;
        for(int n:nums)
        {
             max= Math.max(n,max);
             sum+=n; 
        }

        int low=max;
        int high=sum;

        while(low<=high)
        {
            int mid= low+(high-low)/2;
            if(isPossible(nums,k,mid))
            {
                result=mid;
                // try for another minimum

                high=mid-1;
            }

            else
            {
                low=mid+1;
            }

            
        }

       return result;
    }
  
      private boolean isPossible(int nums[], int k, int limit) {
    int currentSum = 0, subArrayCount = 1;

    for (int num : nums) {
        if (num > limit) return false; // single element exceeds limit
        currentSum += num;

        if (currentSum > limit) {
            subArrayCount++;
            currentSum = num;
        }
    }

    return subArrayCount <= k; // total subarrays needed should be ≤ k
}
        
    }
  

