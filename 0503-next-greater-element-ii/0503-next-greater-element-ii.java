class Solution {
    public int[] nextGreaterElements(int[] nums) 
    {
       int res[] = new int[nums.length];
       int n = nums.length;

       Stack<Integer> stack = new Stack<>();

       for(int i=0;i<nums.length;i++)
       {
         res[i] =-1;
       }

       for(int i=0;i<n*2;i++)
       {
         
         while(!stack.isEmpty() && nums[stack.peek()]<nums[i%n])
         {
                
             res[stack.pop()] = nums[i%n];
         }

         if(i<n)
         {
            stack.push(i);
         }

       }

       return res;
    }
}