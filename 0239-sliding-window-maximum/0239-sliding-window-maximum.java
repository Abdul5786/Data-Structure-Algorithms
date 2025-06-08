class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        int n= nums.length;
        int ans[] = new int[n-k+1]; // result array 
        Deque<Integer> dq = new ArrayDeque<>();

         for(int i=0;i<n;i++)
         {
            while(!dq.isEmpty()&& nums[dq.peekLast()]<=nums[i])
            {
                dq.removeLast();
            }

            dq.addLast(i);

            if(dq.peekFirst()<=i-k)
            {
                dq.removeFirst();
            }

            if(i>=k-1)   // window formed 
            {
             ans[i-k+1]=nums[dq.peekFirst()];
            } 
         }

      return ans;  
    }
    
}