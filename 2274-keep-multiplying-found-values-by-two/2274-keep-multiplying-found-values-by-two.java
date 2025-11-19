class Solution {
    public int findFinalValue(int[] nums, int original) 
    {
         Set<Integer> set =    new HashSet<>();

         for(int num:nums)
         {
            set.add(num);
         }

         int value =original;

         while(set.contains(value))
         {
             value *=2; 
         }

         return value;
    }
}