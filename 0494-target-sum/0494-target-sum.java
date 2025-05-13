class Solution {
    public int findTargetSumWays(int[] nums, int target) 
    {
        return calculate(nums,target,0,0);
    }

    private int calculate(int nums[],int target,int index,int currentSum)
    {
        if(index==nums.length)
        {
           return currentSum==target? 1 :0;
        }


        // recursive call 

        int add= calculate(nums,target,index+1,currentSum+nums[index]);
        int subtract=calculate(nums,target,index+1,currentSum-nums[index]);
        return add+subtract;

    }
}