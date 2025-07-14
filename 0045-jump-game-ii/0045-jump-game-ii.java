class Solution {
    public int jump(int[] nums) 
    {
        int jump=0;
        int farthest=0;
        int currentEnd=0;

        for(int i=0;i<nums.length-1;i++)
        {
            // maximum kaha tka jump kr sakte hain

            farthest= Math.max(farthest,i+nums[i]);

            if(i==currentEnd)
            {
                jump++;
                currentEnd=farthest;
            }

            
        }

        return jump;
    
}

}