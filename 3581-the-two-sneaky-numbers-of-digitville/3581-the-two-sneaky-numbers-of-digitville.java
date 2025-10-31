class Solution {
    public int[] getSneakyNumbers(int[] nums) 
    {
        int index=0;
       int res[] = new int[2];
       HashMap<Integer,Integer> map =   new HashMap<>();
         for(int num : nums)
         {
           map.put(num,map.getOrDefault(num,0)+1);
         }

         for(Map.Entry<Integer,Integer> entry : map.entrySet())
         {
            if(entry.getValue()>=2)
            {
                res[index]=entry.getKey();
                index++;
            }
         }

         return res;

    }
}