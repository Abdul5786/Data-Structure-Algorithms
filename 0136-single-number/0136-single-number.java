class Solution {
    public int singleNumber(int[] nums) 
    {
      Map<Integer,Integer> map =   new HashMap<>();

      for(int num:nums)
      {
       map.put(num,map.getOrDefault(num,0)+1);
      }

      for(Map.Entry<Integer, Integer> entries : map.entrySet())
      {
          if(entries.getValue()==1)
          {
            return entries.getKey();
          }
      }

      return -1;

    }
}