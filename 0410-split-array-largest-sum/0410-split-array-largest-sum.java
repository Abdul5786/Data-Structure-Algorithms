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
    int subarrayCount = 1; // Start with one subarray
    int currentSum = 0;

    for (int num : nums) {
        if (currentSum + num > limit) {
            subarrayCount++;
            currentSum = num; // Reset currentSum to num
            if (subarrayCount > k) { // Too many subarrays needed
                return false;
            }
        } else {
            currentSum += num; // Add num to the current subarray
        }
    }

    return true; // Successfully split into k or fewer subarrays
}
        
    }
  

