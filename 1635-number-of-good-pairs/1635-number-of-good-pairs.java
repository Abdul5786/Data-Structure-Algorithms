class Solution {
    public int numIdenticalPairs(int[] nums) 
    {

       int res=0;
       Map<Integer, Integer> count=  new HashMap<>();


       for(int a:nums)
       {
               res+= count.getOrDefault(a, 0);
              count.put(a,count.getOrDefault(a,0)+1);

       }

       return res;
    }
}