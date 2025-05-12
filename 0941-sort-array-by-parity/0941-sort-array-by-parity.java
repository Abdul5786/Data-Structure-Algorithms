class Solution {
    public int[] sortArrayByParity(int[] nums) 
    {
        int left=0;
        int right=nums.length-1;

        while(left<right)
        {
            if(nums[left]%2!=0 && nums[right]%2==0)
            {
                swap(nums,left,right);
            }

            else if(nums[left]%2==0)
            {
                left++;
            }

            else if(nums[right]%2!=0)
            {
                right--;
            }
        }
        return nums;
    }

            public static void swap(int nums[],int left,int right)
        {
             int temp=nums[right];
             nums[right]= nums[left];
             nums[left]=temp;
        }
}