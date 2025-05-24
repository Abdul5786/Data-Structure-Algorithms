class Solution {
    public int subarraySum(int[] nums, int k) 
    {
       
      int count=0;
      int prefixSum=0;

         Map<Integer,Integer>   map  =  new HashMap<>();
         map.put(0,1);  // to handle case where prefix sum ==k 

         for(int num:nums){

            prefixSum+=num;

            if(map.containsKey(prefixSum-k))
            {
                count+=map.get(prefixSum-k);
            }

            // update the map

            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
         }

         return count; 
    
    }

}