class Solution {
    public int[] searchRange(int[] nums, int target) 
    {
        int l=0;
        int h=nums.length-1;
        int ans[]={-1,-1};
        while(l<=h)
        {
            int mid= (l+h)/2;

            if(nums[mid]==target)
            {
               ans[0]= mid;
               // continue searching to the left 
                h=mid-1;
            }

            else if(nums[mid]<target)
            {
                  l=mid+1;
            }
            else
            {
                h=mid-1;
            }
        }

         l=0;
         h=nums.length-1;

        while(l<=h)
        {
            int mid= (l+h)/2;

            if(nums[mid]==target)
            {
               ans[1]= mid;
               // continue searching to the right side

               l=mid+1;
            }

            else if(nums[mid]<target)
            {
                  l=mid+1;
            }
            else
            {
                h=mid-1;
            }
        }

        return ans;
    }
}